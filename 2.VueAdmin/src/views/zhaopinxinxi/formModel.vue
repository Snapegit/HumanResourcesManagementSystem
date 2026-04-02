<template>
	<div>
		<el-dialog v-model="formVisible" :title="formTitle" width="80%" destroy-on-close :fullscreen='false'>
			<el-form class="formModel_form" ref="formRef" :model="form" label-width="$template2.back.add.form.base.labelWidth" :rules="rules">
				<el-row>
					<el-col :span="12">
						<el-form-item label="岗位名称" prop="gangweimingcheng">
							<el-input class="list_inp" v-model="form.gangweimingcheng" placeholder="岗位名称"
								 type="text" 								:readonly="!isAdd||disabledForm.gangweimingcheng?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="12">
						<el-form-item label="办公环境" prop="bangonghuanjing">
							<uploads
								:disabled="!isAdd||disabledForm.bangonghuanjing?true:false"
								action="file/upload" 
								tip="请上传办公环境" 
								:limit="3" 
								style="width: 100%;text-align: left;"
								:fileUrls="form.bangonghuanjing?form.bangonghuanjing:''" 
								@change="bangonghuanjingUploadSuccess">
							</uploads>
						</el-form-item>
					</el-col>
					<el-col :span="12">
						<el-form-item label="岗位类型" prop="gangweileixing">
							<el-select
								class="list_sel"
								:disabled="!isAdd||disabledForm.gangweileixing?true:false"
								v-model="form.gangweileixing" 
								placeholder="请选择岗位类型"
								>
								<el-option v-for="(item,index) in gangweileixingLists" :label="item"
									:value="item"
									>
								</el-option>
							</el-select>
						</el-form-item>
					</el-col>
					<el-col :span="12">
						<el-form-item label="招聘人数" prop="zhaopinrenshu">
							<el-input class="list_inp" v-model="form.zhaopinrenshu" placeholder="招聘人数"
								 type="text" 								:readonly="!isAdd||disabledForm.zhaopinrenshu?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="12">
						<el-form-item label="专业要求" prop="zhuanyeyaoqiu">
							<el-input class="list_inp" v-model="form.zhuanyeyaoqiu" placeholder="专业要求"
								 type="text" 								:readonly="!isAdd||disabledForm.zhuanyeyaoqiu?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="12">
						<el-form-item label="学历要求" prop="xueliyaoqiu">
							<el-input class="list_inp" v-model="form.xueliyaoqiu" placeholder="学历要求"
								 type="text" 								:readonly="!isAdd||disabledForm.xueliyaoqiu?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="12">
						<el-form-item label="工作年限" prop="gongzuonianxian">
							<el-input class="list_inp" v-model="form.gongzuonianxian" placeholder="工作年限"
								 type="text" 								:readonly="!isAdd||disabledForm.gongzuonianxian?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="12">
						<el-form-item label="薪资待遇" prop="xinzidaiyu">
							<el-input class="list_inp" v-model="form.xinzidaiyu" placeholder="薪资待遇"
								 type="text" 								:readonly="!isAdd||disabledForm.xinzidaiyu?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="12">
						<el-form-item label="工作时间" prop="gongzuoshijian">
							<el-input class="list_inp" v-model="form.gongzuoshijian" placeholder="工作时间"
								 type="text" 								:readonly="!isAdd||disabledForm.gongzuoshijian?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="12">
						<el-form-item label="专员账号" prop="zhuanyuanzhanghao">
							<el-input class="list_inp" v-model="form.zhuanyuanzhanghao" placeholder="专员账号"
								 type="text" 								:readonly="!isAdd||disabledForm.zhuanyuanzhanghao?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="12">
						<el-form-item label="专员名称" prop="zhuanyuanmingcheng">
							<el-input class="list_inp" v-model="form.zhuanyuanmingcheng" placeholder="专员名称"
								 type="text" 								:readonly="!isAdd||disabledForm.zhuanyuanmingcheng?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="12">
						<el-form-item label="联系电话" prop="lianxidianhua">
							<el-input class="list_inp" v-model="form.lianxidianhua" placeholder="联系电话"
								 type="text" 								:readonly="!isAdd||disabledForm.lianxidianhua?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="12">
						<el-form-item label="发布时间" prop="fabushijian">
							<el-input class="list_inp" v-model="form.fabushijian" placeholder="发布时间"
								 type="text" 								:readonly="!isAdd||disabledForm.fabushijian?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="12">
						<el-form-item label="岗位详情" prop="gangweixiangqing">
							<editor :value="form.gangweixiangqing" placeholder="请输入岗位详情" :readonly="!isAdd||disabledForm.gangweixiangqing?true:false"
								class="list_editor" @change="(e)=>editorChange(e,'gangweixiangqing')"></editor>
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
	const tableName = 'zhaopinxinxi'
	const formName = '招聘信息'
	//基础信息
	//form表单
	const form = ref({})
	const disabledForm = ref({
		gangweimingcheng : false,
		bangonghuanjing : false,
		gangweileixing : false,
		zhaopinrenshu : false,
		zhuanyeyaoqiu : false,
		xueliyaoqiu : false,
		gongzuonianxian : false,
		xinzidaiyu : false,
		gongzuoshijian : false,
		gangweixiangqing : false,
		zhuanyuanzhanghao : false,
		zhuanyuanmingcheng : false,
		lianxidianhua : false,
		clicktime : false,
		storeupnum : false,
		clicknum : false,
		fabushijian : false,
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
		gangweimingcheng: [
			{required: true,message: '请输入',trigger: 'blur'}, 
		],
		bangonghuanjing: [
		],
		gangweileixing: [
			{required: true,message: '请输入',trigger: 'blur'}, 
		],
		zhaopinrenshu: [
		],
		zhuanyeyaoqiu: [
		],
		xueliyaoqiu: [
		],
		gongzuonianxian: [
		],
		xinzidaiyu: [
			{required: true,message: '请输入',trigger: 'blur'}, 
		],
		gongzuoshijian: [
		],
		gangweixiangqing: [
		],
		zhuanyuanzhanghao: [
		],
		zhuanyuanmingcheng: [
		],
		lianxidianhua: [
		],
		clicktime: [
		],
		storeupnum: [
			{ validator: validateIntNumber, trigger: 'blur' },
		],
		clicknum: [
			{ validator: validateIntNumber, trigger: 'blur' },
		],
		fabushijian: [
		],
	})
	//表单验证
	
	const formRef = ref(null)
	const id = ref(0)
	const type = ref('')
	//办公环境上传回调
	const bangonghuanjingUploadSuccess=(e)=>{
		form.value.bangonghuanjing = e
	}
	//岗位类型列表
	const gangweileixingLists = ref([])
	//methods

	//获取唯一标识
	const getUUID =()=> {
      return new Date().getTime();
    }
	//重置
	const resetForm = () => {
		form.value = {
			gangweimingcheng: '',
			bangonghuanjing: '',
			gangweileixing: '',
			zhaopinrenshu: '',
			zhuanyeyaoqiu: '',
			xueliyaoqiu: '',
			gongzuonianxian: '',
			xinzidaiyu: '',
			gongzuoshijian: '',
			gangweixiangqing: '',
			zhuanyuanzhanghao: '',
			zhuanyuanmingcheng: '',
			lianxidianhua: '',
			clicktime: '',
			storeupnum: '0',
			clicknum: '0',
			fabushijian: '',
		}
	}
	//获取info
	const getInfo = ()=>{
		context?.$http({
			url: `${tableName}/info/${id.value}`,
			method: 'get'
		}).then(res => {
			let reg=new RegExp('../../../file','g')
			res.data.data.gangweixiangqing = res.data.data.gangweixiangqing?(res.data.data.gangweixiangqing.replace(reg,'../../../cl7341662/file')):'';
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
				if(x=='gangweimingcheng'){
					form.value.gangweimingcheng = row[x];
					disabledForm.value.gangweimingcheng = true;
					continue;
				}
				if(x=='bangonghuanjing'){
					form.value.bangonghuanjing = row[x];
					disabledForm.value.bangonghuanjing = true;
					continue;
				}
				if(x=='gangweileixing'){
					form.value.gangweileixing = row[x];
					disabledForm.value.gangweileixing = true;
					continue;
				}
				if(x=='zhaopinrenshu'){
					form.value.zhaopinrenshu = row[x];
					disabledForm.value.zhaopinrenshu = true;
					continue;
				}
				if(x=='zhuanyeyaoqiu'){
					form.value.zhuanyeyaoqiu = row[x];
					disabledForm.value.zhuanyeyaoqiu = true;
					continue;
				}
				if(x=='xueliyaoqiu'){
					form.value.xueliyaoqiu = row[x];
					disabledForm.value.xueliyaoqiu = true;
					continue;
				}
				if(x=='gongzuonianxian'){
					form.value.gongzuonianxian = row[x];
					disabledForm.value.gongzuonianxian = true;
					continue;
				}
				if(x=='xinzidaiyu'){
					form.value.xinzidaiyu = row[x];
					disabledForm.value.xinzidaiyu = true;
					continue;
				}
				if(x=='gongzuoshijian'){
					form.value.gongzuoshijian = row[x];
					disabledForm.value.gongzuoshijian = true;
					continue;
				}
				if(x=='gangweixiangqing'){
					form.value.gangweixiangqing = row[x];
					disabledForm.value.gangweixiangqing = true;
					continue;
				}
				if(x=='zhuanyuanzhanghao'){
					form.value.zhuanyuanzhanghao = row[x];
					disabledForm.value.zhuanyuanzhanghao = true;
					continue;
				}
				if(x=='zhuanyuanmingcheng'){
					form.value.zhuanyuanmingcheng = row[x];
					disabledForm.value.zhuanyuanmingcheng = true;
					continue;
				}
				if(x=='lianxidianhua'){
					form.value.lianxidianhua = row[x];
					disabledForm.value.lianxidianhua = true;
					continue;
				}
				if(x=='clicktime'){
					form.value.clicktime = row[x];
					disabledForm.value.clicktime = true;
					continue;
				}
				if(x=='storeupnum'){
					form.value.storeupnum = row[x];
					disabledForm.value.storeupnum = true;
					continue;
				}
				if(x=='clicknum'){
					form.value.clicknum = row[x];
					disabledForm.value.clicknum = true;
					continue;
				}
				if(x=='fabushijian'){
					form.value.fabushijian = row[x];
					disabledForm.value.fabushijian = true;
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
			form.value.storeupnum='0'
			form.value.clicknum='0'
			formVisible.value = true
		}

		context?.$http({
			url: `${context?.$toolUtil.storageGet('sessionTable')}/session`,
			method: 'get'
		}).then(res => {
			var json = res.data.data
			if(json.hasOwnProperty('zhuanyuanzhanghao')&& context?.$toolUtil.storageGet("role")!="管理员"){
				form.value.zhuanyuanzhanghao = json.zhuanyuanzhanghao
				disabledForm.value.zhuanyuanzhanghao = true;
			}
			if(json.hasOwnProperty('zhuanyuanmingcheng')&& context?.$toolUtil.storageGet("role")!="管理员"){
				form.value.zhuanyuanmingcheng = json.zhuanyuanmingcheng
				disabledForm.value.zhuanyuanmingcheng = true;
			}
			if(json.hasOwnProperty('lianxidianhua')&& context?.$toolUtil.storageGet("role")!="管理员"){
				form.value.lianxidianhua = json.lianxidianhua
				disabledForm.value.lianxidianhua = true;
			}
		})
		context?.$http({
			url: `option/gangweileixing/gangweileixing`,
			method: 'get'
		}).then(res=>{
			gangweileixingLists.value = res.data.data
		})
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
	//富文本
	const editorChange = (e,name) =>{
		form.value[name] = e
	}
	//提交
	const save=()=>{
		if(form.value.bangonghuanjing!=null) {
			form.value.bangonghuanjing = form.value.bangonghuanjing.replace(new RegExp(context?.$config.url,"g"),"");
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
				// 富文本
				.list_editor {
					background-color: #fff;
					border-radius: 0;
					padding: 0;
					box-shadow: 0 0 0px rgba(85, 255, 255, 0.5);
					margin: 0;
					width: 100%;
					border-color: #ddd;
					border-width: 0;
					border-style: solid;
					height: auto;
				}
				//图片上传样式
				.el-upload-list  {
					//提示语
					.el-upload__tip {
						margin: 7px 0 0;
						color: #999;
						display: flex;
						font-size: 12px;
						justify-content: flex-start;
						align-items: center;
					}
					//外部盒子
					.el-upload--picture-card {
						border: 1px dashed #000;
						cursor: pointer;
						background-color: #fff;
						border-radius: 8px;
						width: 100px;
						line-height: 110px;
						text-align: center;
						height: 100px;
						//图标
						.el-icon{
							color: #000;
							font-size: 32px;
						}
					}
					.el-upload-list__item {
						border: 1px dashed #000;
						cursor: pointer;
						background-color: #fff;
						border-radius: 8px;
						width: 100px;
						line-height: 110px;
						text-align: center;
						height: 100px;
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