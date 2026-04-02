<template>
	<div>
		<el-dialog v-model="formVisible" :title="formTitle" width="80%" destroy-on-close :fullscreen='false'>
			<el-form class="formModel_form" ref="formRef" :model="form" label-width="$template2.back.add.form.base.labelWidth" :rules="rules">
				<el-row>
					<el-col :span="12">
						<el-form-item label="年月份" prop="nianyuefen">
							<el-input class="list_inp" v-model="form.nianyuefen" placeholder="年月份"
								 type="text" 								:readonly="!isAdd||disabledForm.nianyuefen?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="12">
						<el-form-item label="员工工号" prop="yuangonggonghao">
							<el-select
								class="list_sel"
								:disabled="!isAdd||disabledForm.yuangonggonghao?true:false"
								v-model="form.yuangonggonghao" 
								placeholder="请选择员工工号"
								@change="yuangonggonghaoChange">
								<el-option v-for="(item,index) in yuangonggonghaoLists" :label="item" :value="item">
								</el-option>
							</el-select>
						</el-form-item>
					</el-col>
					<el-col :span="12">
						<el-form-item label="员工姓名" prop="yuangongxingming">
							<el-input class="list_inp" v-model="form.yuangongxingming" placeholder="员工姓名"
								 type="text" 								:readonly="!isAdd||disabledForm.yuangongxingming?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="12">
						<el-form-item label="底薪" prop="dixin">
							<el-input class="list_inp" v-model.number="form.dixin" placeholder="底薪"
								 type="number" 								:readonly="!isAdd||disabledForm.dixin?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="12">
						<el-form-item label="绩效" prop="jixiao">
							<el-input class="list_inp" v-model.number="form.jixiao" placeholder="绩效"
								 type="number" 								:readonly="!isAdd||disabledForm.jixiao?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="12">
						<el-form-item label="奖金" prop="jiangjin">
							<el-input class="list_inp" v-model.number="form.jiangjin" placeholder="奖金"
								 type="number" 								:readonly="!isAdd||disabledForm.jiangjin?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="12">
						<el-form-item label="全勤奖" prop="quanqinjiang">
							<el-input class="list_inp" v-model.number="form.quanqinjiang" placeholder="全勤奖"
								 type="number" 								:readonly="!isAdd||disabledForm.quanqinjiang?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="12">
						<el-form-item label="五险一金" prop="wuxianyijin">
							<el-input class="list_inp" v-model.number="form.wuxianyijin" placeholder="五险一金"
								 type="number" 								:readonly="!isAdd||disabledForm.wuxianyijin?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="12">
						<el-form-item label="扣款" prop="koukuan">
							<el-input class="list_inp" v-model.number="form.koukuan" placeholder="扣款"
								 type="number" 								:readonly="!isAdd||disabledForm.koukuan?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="12">
						<el-form-item label="实发工资" prop="shifagongzi">
							<el-input class="list_inp" v-model="shifagongzi" :readonly="true" placeholder="实发工资" />
						</el-form-item>
					</el-col>
					<el-col :span="12">
						<el-form-item label="工资备注" prop="gongzibeizhu">
							<el-input class="list_inp" v-model="form.gongzibeizhu" placeholder="工资备注"
								 type="text" 								:readonly="!isAdd||disabledForm.gongzibeizhu?true:false" />
						</el-form-item>
					</el-col>

				</el-row>
			</el-form>
			<template #footer v-if="isAdd||type=='logistics'||type=='reply'">
				<span class="formModel_btn_box">
					<el-button class="formModel_cancel" @click="closeClick">取消</el-button>
					<el-button class="formModel_confirm" type="primary" @click="save"
						>
						提交
					</el-button>
				</span>
			</template>
		</el-dialog>
	</div>
</template>
<script setup>
	import {
		reactive,
		ref,
		getCurrentInstance,
		nextTick,
		computed,
		defineEmits
	} from 'vue'
	const context = getCurrentInstance()?.appContext.config.globalProperties;	
	const emit = defineEmits(['formModelChange'])
	//基础信息
	const tableName = 'gongzixinxi'
	const formName = '工资信息'
	//基础信息
	//form表单
	const form = ref({})
	const disabledForm = ref({
		nianyuefen : false,
		yuangonggonghao : false,
		yuangongxingming : false,
		dixin : false,
		jixiao : false,
		jiangjin : false,
		quanqinjiang : false,
		wuxianyijin : false,
		koukuan : false,
		shifagongzi : false,
		gongzibeizhu : false,
	})
	const formVisible = ref(false)
	const isAdd = ref(false)
	const formTitle = ref('')
	//表单验证
	//匹配整数
	const validateIntNumber = (rule, value, callback) => {
		if (!value) {
			callback();
		} else if (!context?.$toolUtil.isIntNumer(value)) {
			callback(new Error("请输入整数"));
		} else {
			callback();
		}
	}
	//匹配数字
	const validateNumber = (rule, value, callback) => {
		if(!value){
			callback();
		} else if (!context?.$toolUtil.isNumber(value)) {
			callback(new Error("请输入数字"));
		} else {
			callback();
		}
	}
	//匹配手机号码
	const validateMobile = (rule, value, callback) => {
		if(!value){
			callback();
		} else if (!context?.$toolUtil.isMobile(value)) {
			callback(new Error("请输入正确的手机号码"));
		} else {
			callback();
		}
	}
	//匹配电话号码
	const validatePhone = (rule, value, callback) => {
		if(!value){
			callback();
		} else if (!context?.$toolUtil.isPhone(value)) {
			callback(new Error("请输入正确的电话号码"));
		} else {
			callback();
		}
	}
	//匹配邮箱
	const validateEmail = (rule, value, callback) => {
		if(!value){
			callback();
		} else if (!context?.$toolUtil.isEmail(value)) {
			callback(new Error("请输入正确的邮箱地址"));
		} else {
			callback();
		}
	}
	//匹配身份证
	const validateIdCard = (rule, value, callback) => {
		if(!value){
			callback();
		} else if (!context?.$toolUtil.checkIdCard(value)) {
			callback(new Error("请输入正确的身份证号码"));
		} else {
			callback();
		}
	}
	//匹配网站地址
	const validateUrl = (rule, value, callback) => {
		if(!value){
			callback();
		} else if (!context?.$toolUtil.isURL(value)) {
			callback(new Error("请输入正确的URL地址"));
		} else {
			callback();
		}
	}
	const rules = ref({
		nianyuefen: [
			{required: true,message: '请输入',trigger: 'blur'}, 
		],
		yuangonggonghao: [
			{required: true,message: '请输入',trigger: 'blur'}, 
		],
		yuangongxingming: [
		],
		dixin: [
			{required: true,message: '请输入',trigger: 'blur'}, 
			{ validator: validateNumber, trigger: 'blur' },
		],
		jixiao: [
			{required: true,message: '请输入',trigger: 'blur'}, 
			{ validator: validateNumber, trigger: 'blur' },
		],
		jiangjin: [
			{required: true,message: '请输入',trigger: 'blur'}, 
			{ validator: validateNumber, trigger: 'blur' },
		],
		quanqinjiang: [
			{required: true,message: '请输入',trigger: 'blur'}, 
			{ validator: validateNumber, trigger: 'blur' },
		],
		wuxianyijin: [
			{required: true,message: '请输入',trigger: 'blur'}, 
			{ validator: validateNumber, trigger: 'blur' },
		],
		koukuan: [
			{required: true,message: '请输入',trigger: 'blur'}, 
			{ validator: validateNumber, trigger: 'blur' },
		],
		shifagongzi: [
			{ validator: validateNumber, trigger: 'blur' },
		],
		gongzibeizhu: [
		],
	})
	//表单验证
	
	const formRef = ref(null)
	const id = ref(0)
	const type = ref('')
	//员工工号列表
	const yuangonggonghaoLists = ref([])
	const shifagongzi =computed(()=>{
		let c = form.value
		let a = c.dixin+c.jixiao+c.jiangjin+c.quanqinjiang-c.wuxianyijin-c.koukuan
		form.value.shifagongzi = a?a.toFixed(2) : 0
		return a?a.toFixed(2) : 0
	})
	//methods

	//获取唯一标识
	const getUUID =()=> {
      return new Date().getTime();
    }
	//重置
	const resetForm = () => {
		form.value = {
			nianyuefen: '',
			yuangonggonghao: '',
			yuangongxingming: '',
			dixin: '',
			jixiao: '',
			jiangjin: '',
			quanqinjiang: '',
			wuxianyijin: '',
			koukuan: '',
			shifagongzi: '',
			gongzibeizhu: '',
		}
	}
	//获取info
	const getInfo = ()=>{
		context?.$http({
			url: `${tableName}/info/${id.value}`,
			method: 'get'
		}).then(res => {
			let reg=new RegExp('../../../file','g')
			form.value = res.data.data
			formVisible.value = true
		})
	}
	const crossRow = ref('')
	const crossTable = ref('')
	const crossTips = ref('')
	const crossColumnName = ref('')
	const crossColumnValue = ref('')
	//初始化
	const init=(formId=null,formType='add',formNames='',row=null,table=null,statusColumnName=null,tips=null,statusColumnValue=null)=>{
		resetForm()
		if(formId){
			id.value = formId
			type.value = formType
		}
		if(formType == 'add'){
			isAdd.value = true
			formTitle.value = '新增' + formName
			formVisible.value = true
		}else if(formType == 'info'){
			isAdd.value = false
			formTitle.value = '查看' + formName
			getInfo()
		}else if(formType == 'edit'){
			isAdd.value = true
			formTitle.value = '修改' + formName
			getInfo()
		}
		else if(formType == 'cross'){
			isAdd.value = true
			formTitle.value = formNames
			// getInfo()
			for(let x in row){
				if(x=='nianyuefen'){
					form.value.nianyuefen = row[x];
					disabledForm.value.nianyuefen = true;
					continue;
				}
				if(x=='yuangonggonghao'){
					form.value.yuangonggonghao = row[x];
					disabledForm.value.yuangonggonghao = true;
					continue;
				}
				if(x=='yuangongxingming'){
					form.value.yuangongxingming = row[x];
					disabledForm.value.yuangongxingming = true;
					continue;
				}
				if(x=='dixin'){
					form.value.dixin = row[x];
					disabledForm.value.dixin = true;
					continue;
				}
				if(x=='jixiao'){
					form.value.jixiao = row[x];
					disabledForm.value.jixiao = true;
					continue;
				}
				if(x=='jiangjin'){
					form.value.jiangjin = row[x];
					disabledForm.value.jiangjin = true;
					continue;
				}
				if(x=='quanqinjiang'){
					form.value.quanqinjiang = row[x];
					disabledForm.value.quanqinjiang = true;
					continue;
				}
				if(x=='wuxianyijin'){
					form.value.wuxianyijin = row[x];
					disabledForm.value.wuxianyijin = true;
					continue;
				}
				if(x=='koukuan'){
					form.value.koukuan = row[x];
					disabledForm.value.koukuan = true;
					continue;
				}
				if(x=='shifagongzi'){
					form.value.shifagongzi = row[x];
					disabledForm.value.shifagongzi = true;
					continue;
				}
				if(x=='gongzibeizhu'){
					form.value.gongzibeizhu = row[x];
					disabledForm.value.gongzibeizhu = true;
					continue;
				}
			}
			if(row){
				crossRow.value = row
			}
			if(table){
				crossTable.value = table
			}
			if(tips){
				crossTips.value = tips
			}
			if(statusColumnName){
				crossColumnName.value = statusColumnName
			}
			if(statusColumnValue){
				crossColumnValue.value = statusColumnValue
			}
			formVisible.value = true
		}

		context?.$http({
			url: `${context?.$toolUtil.storageGet('sessionTable')}/session`,
			method: 'get'
		}).then(res => {
			var json = res.data.data
		})
		context?.$http({
			url: `option/yuangong/yuangonggonghao`,
			method: 'get'
		}).then(res=>{
			yuangonggonghaoLists.value = res.data.data
		})
		//由上级字段带出不可改
		disabledForm.value.yuangongxingming = true;
	}
	//初始化
	//声明父级调用
	defineExpose({
		init
	})
	//关闭
	const closeClick = () => {
		formVisible.value = false
	}
	const yuangonggonghaoChange=()=>{
		context?.$http({
			url: `follow/yuangong/yuangonggonghao?columnValue=` + form.value.yuangonggonghao,
			method: 'get'
		}).then(res=>{
			if(res.data.data.yuangongxingming){
				form.value.yuangongxingming = res.data.data.yuangongxingming
			}
		})
	}
	//富文本
	const editorChange = (e,name) =>{
		form.value[name] = e
	}
	//提交
	const save=()=>{
		var table = crossTable.value
		var objcross = JSON.parse(JSON.stringify(crossRow.value))
		let crossUserId = ''
		let crossRefId = ''
		let crossOptNum = ''
		if(type.value == 'cross'){
			if(crossColumnName.value!=''){
				if(!crossColumnName.value.startsWith('[')){
					for(let o in objcross){
						if(o == crossColumnName.value){
							objcross[o] = crossColumnValue.value
						}
					}
					//修改跨表数据
					changeCrossData(objcross)
				}else{
					crossUserId = context?.$toolUtil.storageGet('userid')
					crossRefId = objcross['id']
					crossOptNum = crossColumnName.value.replace(/\[/,"").replace(/\]/,"")
				}
			}
		}
		formRef.value.validate((valid)=>{
			if(valid){
				if(crossUserId&&crossRefId){
					form.value.crossuserid = crossUserId
					form.value.crossrefid = crossRefId
					let params = {
						page: 1,
						limit: 1000, 
						crossuserid:form.value.crossuserid,
						crossrefid:form.value.crossrefid,
					}
					context?.$http({
						url: `${tableName}/page`,
						method: 'get', 
						params: params 
					}).then(res=>{
						if(res.data.data.total>=crossOptNum){
							context?.$toolUtil.message(`${crossTips.value}`,'error')
							return false
						}else{
							context?.$http({
								url: `${tableName}/${!form.value.id ? "save" : "update"}`,
								method: 'post', 
								data: form.value 
							}).then(res=>{
								context?.$toolUtil.message(`操作成功`,'success',()=>{
									formVisible.value = false
									emit('formModelChange')
								})
							})
						}
					})
				}else{
					context?.$http({
						url: `${tableName}/${!form.value.id ? "save" : "update"}`,
						method: 'post', 
						data: form.value 
					}).then(res=>{
						context?.$toolUtil.message(`操作成功`,'success',()=>{
							formVisible.value = false
							emit('formModelChange')
						})
					})
				}
			}
		})
	}
	//修改跨表数据
	const changeCrossData=(row)=>{
		context?.$http({
			url: `${crossTable.value}/update`,
			method: 'post',
			data: row
		}).then(res=>{})
	}
</script>
<style lang="scss" scoped>
	// 表单
	.formModel_form{
		border-radius: 6px;
		padding: 30px;
		box-shadow: 0 0px 0px rgba(85, 255, 255, 0.5);
		// form item
		:deep(.el-form-item) {
			border: 1px solid #ddd;
			margin: 0;
			display: flex;
			//label
			.el-form-item__label {
			 border: 1px solid #ddd;
			 padding: 0;
			 background: rgba(236,236,236,1);
			 display: block;
			 width: 120px;
			 border-width: 0 2px 0 0;
			 text-align: center;
			}
			// 内容盒子
			.el-form-item__content {
				padding: 0 20px;
				display: flex;
				width: calc(100% - 120px);
				justify-content: flex-start;
				align-items: center;
				flex-wrap: wrap;
				// 输入框
				.list_inp {
					border: 1px solid #ddd;
					box-shadow: 0 0 0px rgba(85, 255, 255, 0.5);
					padding: 0 10px;
					width: 100%;
					line-height: 36px;
					box-sizing: border-box;
					height: 36px;
					//去掉默认样式
					.el-input__wrapper{
						border: none;
						box-shadow: none;
						background: none;
						border-radius: 0;
						height: 100%;
						padding: 0;
					}
					.is-focus {
						box-shadow: none !important;
					}
				}
				// 下拉框
				.list_sel {
					border: 1px solid #ddd;
					border-radius: 0;
					box-shadow: 0 0 0px rgba(85, 255, 255, 0.5);
					padding: 0 10px;
					width: 100%;
					line-height: 36px;
					box-sizing: border-box;
					//去掉默认样式
					.select-trigger{
						height: 100%;
						.el-input{
							height: 100%;
							.el-input__wrapper{
								border: none;
								box-shadow: none;
								background: none;
								border-radius: 0;
								height: 100%;
								padding: 0;
							}
							.is-focus {
								box-shadow: none !important;
							}
						}
					}
				}
			}
		}
	}
	// 按钮盒子
	.formModel_btn_box {
		padding: 40px 0 0;
		display: flex;
		width: 100%;
		justify-content: center;
		align-items: center;
		.formModel_cancel {
			border: 0;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 24px;
			margin: 0 10px 0 0;
			outline: none;
			color: #fff;
			background: rgba(27, 78, 133, 1);
			width: auto;
			font-size: 14px;
			height: 32px;
		}
		.formModel_cancel:hover {
			background: rgba(27, 78, 133, 0.5);
		}
		
		.formModel_confirm {
			border: 0;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 24px;
			margin: 0 10px 0 0;
			outline: none;
			color: #fff;
			background: rgba(241, 49, 100, 1);
			width: auto;
			font-size: 14px;
			height: 32px;
		}
		.formModel_confirm:hover {
			background: rgba(241, 49, 100, .5);
		}
	}
</style>