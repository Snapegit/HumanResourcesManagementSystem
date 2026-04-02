
<template>
	<div class="app-contain" :style='{"minHeight":"100vh","padding":"0","margin":"20px auto 60px","borderRadius":"0px","background":"#fff","width":"76%","position":"relative","height":"100%"}'>
		<div class="bread_view">
			<el-breadcrumb separator=">" class="breadcrumb">
				<el-breadcrumb-item class="first_breadcrumb" :to="{ path: '/' }">首页</el-breadcrumb-item>
				<el-breadcrumb-item class="second_breadcrumb" v-for="(item,index) in breadList" :key="index">{{item.name}}</el-breadcrumb-item>
			</el-breadcrumb>
		</div>
		<el-form ref="formRef" :model="form" class="add_form" label-width="120px" :rules="rules">
			<el-row>
				<el-col :span="8">
					<el-form-item label="岗位名称" prop="gangweimingcheng">
						<el-input class="list_inp" v-model="form.gangweimingcheng" placeholder="岗位名称"
							 type="text" 							:readonly="!isAdd||disabledForm.gangweimingcheng?true:false" />
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
				<el-col :span="8">
					<el-form-item label="岗位类型" prop="gangweileixing">
						<el-select
							class="list_sel"
							:disabled="!isAdd||disabledForm.gangweileixing?true:false"
							v-model="form.gangweileixing" 
							placeholder="请选择岗位类型"
							style="width:100%;"
							>
							<el-option v-for="(item,index) in gangweileixingLists" :label="item"
								:value="item"
								>
							</el-option>
						</el-select>
					</el-form-item>
				</el-col>
				<el-col :span="8">
					<el-form-item label="招聘人数" prop="zhaopinrenshu">
						<el-input class="list_inp" v-model="form.zhaopinrenshu" placeholder="招聘人数"
							 type="text" 							:readonly="!isAdd||disabledForm.zhaopinrenshu?true:false" />
					</el-form-item>
				</el-col>

				<el-col :span="8">
					<el-form-item label="专业要求" prop="zhuanyeyaoqiu">
						<el-input class="list_inp" v-model="form.zhuanyeyaoqiu" placeholder="专业要求"
							 type="text" 							:readonly="!isAdd||disabledForm.zhuanyeyaoqiu?true:false" />
					</el-form-item>
				</el-col>

				<el-col :span="8">
					<el-form-item label="学历要求" prop="xueliyaoqiu">
						<el-input class="list_inp" v-model="form.xueliyaoqiu" placeholder="学历要求"
							 type="text" 							:readonly="!isAdd||disabledForm.xueliyaoqiu?true:false" />
					</el-form-item>
				</el-col>

				<el-col :span="8">
					<el-form-item label="工作年限" prop="gongzuonianxian">
						<el-input class="list_inp" v-model="form.gongzuonianxian" placeholder="工作年限"
							 type="text" 							:readonly="!isAdd||disabledForm.gongzuonianxian?true:false" />
					</el-form-item>
				</el-col>

				<el-col :span="8">
					<el-form-item label="薪资待遇" prop="xinzidaiyu">
						<el-input class="list_inp" v-model="form.xinzidaiyu" placeholder="薪资待遇"
							 type="text" 							:readonly="!isAdd||disabledForm.xinzidaiyu?true:false" />
					</el-form-item>
				</el-col>

				<el-col :span="8">
					<el-form-item label="工作时间" prop="gongzuoshijian">
						<el-input class="list_inp" v-model="form.gongzuoshijian" placeholder="工作时间"
							 type="text" 							:readonly="!isAdd||disabledForm.gongzuoshijian?true:false" />
					</el-form-item>
				</el-col>

				<el-col :span="8">
					<el-form-item label="专员账号" prop="zhuanyuanzhanghao">
						<el-input class="list_inp" v-model="form.zhuanyuanzhanghao" placeholder="专员账号"
							 type="text" 							:readonly="!isAdd||disabledForm.zhuanyuanzhanghao?true:false" />
					</el-form-item>
				</el-col>

				<el-col :span="8">
					<el-form-item label="专员名称" prop="zhuanyuanmingcheng">
						<el-input class="list_inp" v-model="form.zhuanyuanmingcheng" placeholder="专员名称"
							 type="text" 							:readonly="!isAdd||disabledForm.zhuanyuanmingcheng?true:false" />
					</el-form-item>
				</el-col>

				<el-col :span="8">
					<el-form-item label="联系电话" prop="lianxidianhua">
						<el-input class="list_inp" v-model="form.lianxidianhua" placeholder="联系电话"
							 type="text" 							:readonly="!isAdd||disabledForm.lianxidianhua?true:false" />
					</el-form-item>
				</el-col>

				<el-col :span="8">
					<el-form-item label="发布时间" prop="fabushijian">
						<el-input class="list_inp" v-model="form.fabushijian" placeholder="发布时间"
							 type="text" 							:readonly="!isAdd||disabledForm.fabushijian?true:false" />
					</el-form-item>
				</el-col>

				<el-col :span="24">
					<el-form-item label="岗位详情" prop="gangweixiangqing">
						<editor class="list_editor" :value="form.gangweixiangqing" placeholder="请输入岗位详情" :readonly="!isAdd||disabledForm.gangweixiangqing?true:false"
							@change="(e)=>editorChange(e,'gangweixiangqing')"></editor>
					</el-form-item>
				</el-col>
			</el-row>
			<div class="formModel_btn_box">
				<el-button class="formModel_cancel" @click="backClick">取消</el-button>
				<el-button class="formModel_confirm" @click="save"
					type="success"
					>
					保存
				</el-button>
			</div>
		</el-form>
	</div>
</template>
<script setup>
	import {
		ref,
		getCurrentInstance,
		watch,
		onUnmounted,
		onMounted,
		nextTick,
		computed
	} from 'vue';
	import {
		useRoute,
		useRouter
	} from 'vue-router';
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	const route = useRoute()
	const router = useRouter()
	//基础信息
	const tableName = 'zhaopinxinxi'
	const formName = '招聘信息'
	//基础信息
	const breadList = ref([{
		name: formName
	}])
	//获取唯一标识
	const getUUID =()=> {
      return new Date().getTime();
    }
	//form表单
	const form = ref({
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
	})
	const formRef = ref(null)
	const id = ref(0)
	const type = ref('')
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
	const isAdd = ref(false)
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
	//办公环境上传回调
	const bangonghuanjingUploadSuccess=(e)=>{
		form.value.bangonghuanjing = e
	}
	//岗位类型列表
	const gangweileixingLists = ref([])
	//methods

	//methods
	//获取info
	const getInfo = ()=>{
		context?.$http({
			url: `${tableName}/info/${id.value}`,
			method: 'get'
		}).then(res => {
			let reg=new RegExp('../../../file','g')
			res.data.data.gangweixiangqing = res.data.data.gangweixiangqing.replace(reg,'../../../cl7341662/file');
			form.value = res.data.data
		})
	}
	const crossRow = ref('')
	const crossTable = ref('')
	const crossTips = ref('')
	const crossColumnName = ref('')
	const crossColumnValue = ref('')
	//初始化
	const init = (formId=null,formType='add',formNames='',row=null,table=null,statusColumnName=null,tips=null,statusColumnValue=null) => {
		if(formId){
			id.value = formId
			type.value = formType
		}
		if(formType == 'add'){
			isAdd.value = true
		}else if(formType == 'info'){
			isAdd.value = false
			getInfo()
		}else if(formType == 'edit'){
			isAdd.value = true
			getInfo()
		}
		else if(formType == 'cross'){
			isAdd.value = true
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
		}
		context?.$http({
			url: `${context?.$toolUtil.storageGet('frontSessionTable')}/session`,
			method: 'get'
		}).then(res => {
			var json = res.data.data
			if(json.hasOwnProperty('zhuanyuanzhanghao') && context?.$toolUtil.storageGet("frontRole")!="管理员"){
				form.value.zhuanyuanzhanghao = json.zhuanyuanzhanghao
				disabledForm.value.zhuanyuanzhanghao = true;
			}
			if(json.hasOwnProperty('zhuanyuanmingcheng') && context?.$toolUtil.storageGet("frontRole")!="管理员"){
				form.value.zhuanyuanmingcheng = json.zhuanyuanmingcheng
				disabledForm.value.zhuanyuanmingcheng = true;
			}
			if(json.hasOwnProperty('lianxidianhua') && context?.$toolUtil.storageGet("frontRole")!="管理员"){
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
	//取消
	const backClick = () => {
		history.back()
	}
	//富文本数据回调
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
									history.back()
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
							history.back()
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
	onMounted(()=>{
		type.value = route.query.type?route.query.type:'add'
		let row = null
		let table = null
		let statusColumnName = null
		let tips = null
		let statusColumnValue = null
		if(type.value == 'cross'){
			row = context?.$toolUtil.storageGet('crossObj')?JSON.parse(context?.$toolUtil.storageGet('crossObj')):{}
			table = context?.$toolUtil.storageGet('crossTable')
			statusColumnName = context?.$toolUtil.storageGet('crossStatusColumnName')
			tips = context?.$toolUtil.storageGet('crossTips')
			statusColumnValue = context?.$toolUtil.storageGet('crossStatusColumnValue')
		}
		init(route.query.id?route.query.id:null, type.value,'', row, table, statusColumnName, tips, statusColumnValue)
	})
	
</script>
<style lang="scss" scoped>
	// 面包屑盒子
	.bread_view {
		border-radius: 0px;
		padding: 12px 0px;
		margin: 0px auto;
		background: none;
		width: 100%;
		border-color: #eee;
		border-width: 0 0 0px;
		position: relative;
		border-style: solid;
		:deep(.breadcrumb) {
			font-size: 14px;
			line-height: 1;
			.el-breadcrumb__separator {
				margin: 0 9px;
				color: #999;
				font-weight: 500;
			}
			.first_breadcrumb {
				.el-breadcrumb__inner {
					color: #333;
					display: inline-block;
				}
			}
			.second_breadcrumb {
				.el-breadcrumb__inner {
					color: #999;
					display: inline-block;
				}
			}
		}
	}
	// 表单
	.add_form{
		border: 1px solid #ddd;
		border-radius: 0px;
		padding: 40px 7% 50px;
		background: #fff;
		// form item
		:deep(.el-form-item) {
			border: 0px solid #eee;
			padding: 6px 0;
			margin: 0 0 20px 0;
			background: none;
			display: flex;
			//label
			.el-form-item__label {
			 background: none;
			 display: block;
			 width: auto;
			 min-width: 150px;
			 text-align: right;
			}
			// 内容盒子
			.el-form-item__content {
				display: flex;
				width: calc(100% - 150px);
				justify-content: flex-start;
				align-items: center;
				flex-wrap: wrap;
				// 输入框
				.list_inp {
					padding: 0 10px;
					background: #fff;
					width: auto;
					border-color: #ccc;
					border-width: 1px;
					line-height: 36px;
					box-sizing: border-box;
					border-style: solid;
					min-width: 100%;
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
					border-radius: 0px;
					padding: 0 10px;
					background: #fff;
					width: auto;
					border-color: #ccc;
					border-width: 1px;
					line-height: 36px;
					box-sizing: border-box;
					border-style: solid;
					min-width: 100%;
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
					border-radius: 0;
					padding: 0;
					margin: 0;
					background: #fff;
					width: 99%;
					min-height: 250px;
					border-color: #ddd;
					border-width: 1px;
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
						font-size: 14px;
						justify-content: flex-start;
						align-items: center;
					}
					//外部盒子
					.el-upload--picture-card {
						border: 1px solid #ccc;
						cursor: pointer;
						border-radius: 0px;
						background: #fff;
						width: 150px;
						line-height: 90px;
						text-align: center;
						height: 80px;
						//图标
						.el-icon{
							color: #999;
							font-weight: 600;
							font-size: 24px;
						}
					}
					.el-upload-list__item {
						border: 1px solid #ccc;
						cursor: pointer;
						border-radius: 0px;
						background: #fff;
						width: 150px;
						line-height: 90px;
						text-align: center;
						height: 80px;
					}
				}
			}
		}
	}
	// 按钮盒子
	.formModel_btn_box {
		padding: 0 150px;
		display: flex;
		width: 100%;
		justify-content: center;
		align-items: center;
		.formModel_cancel {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 0px;
			padding: 0 40px;
			margin: 0 20px 0 0;
			color: #fff;
			background: rgb(45, 152, 243);
			width: auto;
			font-size: 14px;
			line-height: 40px;
			transition: all 0.3s;
			height: 40px;
		}
		.formModel_cancel:hover {
		}
		
		.formModel_confirm {
			border: 0px solid #11396190;
			cursor: pointer;
			border-radius: 0px;
			padding: 0 40px;
			margin: 0 20px 0 0;
			color: #fff;
			background: #f03d36;
			width: auto;
			font-size: 14px;
			line-height: 40px;
			transition: all 0.3s;
			height: 40px;
		}
		.formModel_confirm:hover {
		}
	}
</style>