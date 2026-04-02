<template>
	<div>
		<el-dialog v-model="formVisible" :title="formTitle" width="80%" destroy-on-close :fullscreen='false'>
			<el-form class="formModel_form" ref="formRef" :model="form" label-width="$template2.back.add.form.base.labelWidth" :rules="rules">
				<el-row>
					<el-col :span="12">
						<el-form-item label="档案编号" prop="danganbianhao">
							<el-input class="list_inp" v-model="form.danganbianhao" :readonly="true" placeholder="档案编号" />
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
						<el-form-item label="性别" prop="xingbie">
							<el-input class="list_inp" v-model="form.xingbie" placeholder="性别"
								 type="text" 								:readonly="!isAdd||disabledForm.xingbie?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="12">
						<el-form-item label="联系电话" prop="lianxidianhua">
							<el-input class="list_inp" v-model="form.lianxidianhua" placeholder="联系电话"
								 type="text" 								:readonly="!isAdd||disabledForm.lianxidianhua?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="12">
						<el-form-item label="身份证号" prop="shenfenzhenghao">
							<el-input class="list_inp" v-model="form.shenfenzhenghao" placeholder="身份证号"
								 type="text" 								:readonly="!isAdd||disabledForm.shenfenzhenghao?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="12">
						<el-form-item label="部门" prop="bumen">
							<el-input class="list_inp" v-model="form.bumen" placeholder="部门"
								 type="text" 								:readonly="!isAdd||disabledForm.bumen?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="12">
						<el-form-item label="职位" prop="zhiwei">
							<el-input class="list_inp" v-model="form.zhiwei" placeholder="职位"
								 type="text" 								:readonly="!isAdd||disabledForm.zhiwei?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="12">
						<el-form-item label="入职日期" prop="ruzhiriqi">
							<el-date-picker
								class="list_date"
								v-model="form.ruzhiriqi"
								format="YYYY 年 MM 月 DD 日"
								value-format="YYYY-MM-DD"
								type="datetime"
								:readonly="!isAdd||disabledForm.ruzhiriqi?true:false"
								placeholder="请选择入职日期" />
						</el-form-item>
					</el-col>
					<el-col :span="12">
						<el-form-item label="档案文件" prop="danganwenjian">
							<uploads
								:disabled="!isAdd||disabledForm.danganwenjian?true:false"
								type="file"
								action="file/upload" 
								tip="请上传档案文件" 
								:limit="1" 
								style="width: 100%;text-align: left;"
								:fileUrls="form.danganwenjian?form.danganwenjian:''" 
								@change="danganwenjianUploadSuccess">
							</uploads>
						</el-form-item>
					</el-col>
					<el-col :span="12">
						<el-form-item label="备注" prop="beizhu">
							<el-input class="list_inp" v-model="form.beizhu" placeholder="备注"
								 type="text" 								:readonly="!isAdd||disabledForm.beizhu?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="12">
						<el-form-item label="合同" prop="hetong">
							<uploads
								:disabled="!isAdd||disabledForm.hetong?true:false"
								type="file"
								action="file/upload" 
								tip="请上传合同" 
								:limit="1" 
								style="width: 100%;text-align: left;"
								:fileUrls="form.hetong?form.hetong:''" 
								@change="hetongUploadSuccess">
							</uploads>
						</el-form-item>
					</el-col>
					<el-col :span="12">
						<el-form-item label="履历" prop="lvli">
							<el-input v-model="form.lvli" placeholder="履历" type="textarea"
							:readonly="!isAdd||disabledForm.lvli?true:false"
							/>
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
	const tableName = 'renshidangan'
	const formName = '人事档案'
	//基础信息
	//form表单
	const form = ref({})
	const disabledForm = ref({
		danganbianhao : false,
		yuangonggonghao : false,
		yuangongxingming : false,
		xingbie : false,
		lianxidianhua : false,
		shenfenzhenghao : false,
		bumen : false,
		zhiwei : false,
		lvli : false,
		ruzhiriqi : false,
		danganwenjian : false,
		beizhu : false,
		hetong : false,
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
		danganbianhao: [
		],
		yuangonggonghao: [
			{required: true,message: '请输入',trigger: 'blur'}, 
		],
		yuangongxingming: [
		],
		xingbie: [
		],
		lianxidianhua: [
		],
		shenfenzhenghao: [
		],
		bumen: [
			{required: true,message: '请输入',trigger: 'blur'}, 
		],
		zhiwei: [
		],
		lvli: [
		],
		ruzhiriqi: [
			{required: true,message: '请输入',trigger: 'blur'}, 
		],
		danganwenjian: [
		],
		beizhu: [
		],
		hetong: [
		],
	})
	//表单验证
	
	const formRef = ref(null)
	const id = ref(0)
	const type = ref('')
	//员工工号列表
	const yuangonggonghaoLists = ref([])
	//档案文件上传回调
	const danganwenjianUploadSuccess=(e)=>{
		form.value.danganwenjian = e
	}
	//合同上传回调
	const hetongUploadSuccess=(e)=>{
		form.value.hetong = e
	}
	//methods

	//获取唯一标识
	const getUUID =()=> {
      return new Date().getTime();
    }
	//重置
	const resetForm = () => {
		form.value = {
			danganbianhao: getUUID(),
			yuangonggonghao: '',
			yuangongxingming: '',
			xingbie: '',
			lianxidianhua: '',
			shenfenzhenghao: '',
			bumen: '',
			zhiwei: '',
			lvli: '',
			ruzhiriqi: '',
			danganwenjian: '',
			beizhu: '',
			hetong: '',
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
				if(x=='danganbianhao'){
					form.value.danganbianhao = row[x];
					disabledForm.value.danganbianhao = true;
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
				if(x=='xingbie'){
					form.value.xingbie = row[x];
					disabledForm.value.xingbie = true;
					continue;
				}
				if(x=='lianxidianhua'){
					form.value.lianxidianhua = row[x];
					disabledForm.value.lianxidianhua = true;
					continue;
				}
				if(x=='shenfenzhenghao'){
					form.value.shenfenzhenghao = row[x];
					disabledForm.value.shenfenzhenghao = true;
					continue;
				}
				if(x=='bumen'){
					form.value.bumen = row[x];
					disabledForm.value.bumen = true;
					continue;
				}
				if(x=='zhiwei'){
					form.value.zhiwei = row[x];
					disabledForm.value.zhiwei = true;
					continue;
				}
				if(x=='lvli'){
					form.value.lvli = row[x];
					disabledForm.value.lvli = true;
					continue;
				}
				if(x=='ruzhiriqi'){
					form.value.ruzhiriqi = row[x];
					disabledForm.value.ruzhiriqi = true;
					continue;
				}
				if(x=='danganwenjian'){
					form.value.danganwenjian = row[x];
					disabledForm.value.danganwenjian = true;
					continue;
				}
				if(x=='beizhu'){
					form.value.beizhu = row[x];
					disabledForm.value.beizhu = true;
					continue;
				}
				if(x=='hetong'){
					form.value.hetong = row[x];
					disabledForm.value.hetong = true;
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
		//由上级字段带出不可改
		disabledForm.value.xingbie = true;
		//由上级字段带出不可改
		disabledForm.value.lianxidianhua = true;
		//由上级字段带出不可改
		disabledForm.value.shenfenzhenghao = true;
		//由上级字段带出不可改
		disabledForm.value.bumen = true;
		//由上级字段带出不可改
		disabledForm.value.zhiwei = true;
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
			if(res.data.data.xingbie){
				form.value.xingbie = res.data.data.xingbie
			}
			if(res.data.data.lianxidianhua){
				form.value.lianxidianhua = res.data.data.lianxidianhua
			}
			if(res.data.data.shenfenzhenghao){
				form.value.shenfenzhenghao = res.data.data.shenfenzhenghao
			}
			if(res.data.data.bumen){
				form.value.bumen = res.data.data.bumen
			}
			if(res.data.data.zhiwei){
				form.value.zhiwei = res.data.data.zhiwei
			}
		})
	}
	//富文本
	const editorChange = (e,name) =>{
		form.value[name] = e
	}
	//提交
	const save=()=>{
		if(form.value.danganwenjian!=null) {
			form.value.danganwenjian = form.value.danganwenjian.replace(new RegExp(context?.$config.url,"g"),"");
		}
		if(form.value.hetong!=null) {
			form.value.hetong = form.value.hetong.replace(new RegExp(context?.$config.url,"g"),"");
		}
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
				//日期选择器
				.list_date {
					border: 1px solid #ddd;
					border-radius: 0;
					box-shadow: 0 0 0px rgba(85, 255, 255, 0.5);
					width: 100%;
					line-height: 36px;
					box-sizing: border-box;
					//去掉默认样式
					.el-input__wrapper{
						border: none;
						box-shadow: none;
						background: none;
						border-radius: 0;
						height: 100%;
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
				// 长文本
				.el-textarea__inner {
					border: 1px solid #ddd;
					border-radius: 0;
					padding: 12px;
					outline: none;
					color: #333;
					width: 100%;
					font-size: 14px;
					min-height: 120px;
				}
				//文件上传样式
				.upload-demo {
					width: 100%;
					//外部盒子
					.el-upload-dragger {
						border: 1px dashed #000;
						cursor: pointer;
						background-color: #fff;
						border-radius: 6px;
						overflow: hidden;
						flex-direction: column;
						display: flex;
						width: 200px;
						align-items: center;
						box-sizing: border-box;
						text-align: center;
						height: 100px;
					}
					//图标
					.el-icon--upload {
						color: #000;
						font-size: 50px;
						line-height: 0;
					}
					//提示文字
					.el-upload__text {
						margin: 7px 0 0;
						color: #999;
						font-size: 12px;
						em {
							color: #409EFF;
						}
					}
					//提示文字
					.el-upload__tip {
						margin: 7px 0 0;
						color: #999;
						font-size: 12px;
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