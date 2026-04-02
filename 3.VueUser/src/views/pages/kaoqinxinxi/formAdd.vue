
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
					<el-form-item label="员工工号" prop="yuangonggonghao">
						<el-select
							class="list_sel"
							:disabled="!isAdd||disabledForm.yuangonggonghao?true:false"
							v-model="form.yuangonggonghao" 
							placeholder="请选择员工工号"
							style="width:100%;"
							@change="yuangonggonghaoChange">
							<el-option v-for="(item,index) in yuangonggonghaoLists" :label="item" :value="item">
							</el-option>
						</el-select>
					</el-form-item>
				</el-col>
				<el-col :span="8">
					<el-form-item label="员工姓名" prop="yuangongxingming">
						<el-input class="list_inp" v-model="form.yuangongxingming" placeholder="员工姓名"
							 type="text" 							:readonly="!isAdd||disabledForm.yuangongxingming?true:false" />
					</el-form-item>
				</el-col>

				<el-col :span="8">
					<el-form-item label="部门" prop="bumen">
						<el-input class="list_inp" v-model="form.bumen" placeholder="部门"
							 type="text" 							:readonly="!isAdd||disabledForm.bumen?true:false" />
					</el-form-item>
				</el-col>

				<el-col :span="8">
					<el-form-item label="出勤天数" prop="chuqintianshu">
						<el-input class="list_inp" v-model.number="form.chuqintianshu" placeholder="出勤天数"
							 type="text" 							:readonly="!isAdd||disabledForm.chuqintianshu?true:false" />
					</el-form-item>
				</el-col>

				<el-col :span="8">
					<el-form-item label="请假天数" prop="qingjiatianshu">
						<el-input class="list_inp" v-model.number="form.qingjiatianshu" placeholder="请假天数"
							 type="text" 							:readonly="!isAdd||disabledForm.qingjiatianshu?true:false" />
					</el-form-item>
				</el-col>

				<el-col :span="8">
					<el-form-item label="迟到天数" prop="chidaotianshu">
						<el-input class="list_inp" v-model.number="form.chidaotianshu" placeholder="迟到天数"
							 type="text" 							:readonly="!isAdd||disabledForm.chidaotianshu?true:false" />
					</el-form-item>
				</el-col>

				<el-col :span="8">
					<el-form-item label="早退次数" prop="zaotuicishu">
						<el-input class="list_inp" v-model.number="form.zaotuicishu" placeholder="早退次数"
							 type="text" 							:readonly="!isAdd||disabledForm.zaotuicishu?true:false" />
					</el-form-item>
				</el-col>

				<el-col :span="8">
					<el-form-item label="缺勤天数" prop="queqintianshu">
						<el-input class="list_inp" v-model.number="form.queqintianshu" placeholder="缺勤天数"
							 type="text" 							:readonly="!isAdd||disabledForm.queqintianshu?true:false" />
					</el-form-item>
				</el-col>

				<el-col :span="8">
					<el-form-item label="统计时间" prop="tongjishijian">
						<el-date-picker
							class="list_date"
							v-model="form.tongjishijian"
							format="YYYY-MM-DD HH:mm:ss"
							value-format="YYYY-MM-DD HH:mm:ss"
							type="datetime"
							style="width:100%;"
							:readonly="!isAdd||disabledForm.tongjishijian?true:false"
							placeholder="请选择统计时间" />
					</el-form-item>
				</el-col>
				<el-col :span="8">
					<el-form-item label="专员账号" prop="zhuanyuanzhanghao">
						<el-input class="list_inp" v-model="form.zhuanyuanzhanghao" placeholder="专员账号"
							 type="text" 							:readonly="!isAdd||disabledForm.zhuanyuanzhanghao?true:false" />
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
	const tableName = 'kaoqinxinxi'
	const formName = '考勤信息'
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
		yuangonggonghao: '',
		yuangongxingming: '',
		bumen: '',
		chuqintianshu: '',
		qingjiatianshu: '',
		chidaotianshu: '',
		zaotuicishu: '',
		queqintianshu: '',
		tongjishijian: '',
		zhuanyuanzhanghao: '',
	})
	const formRef = ref(null)
	const id = ref(0)
	const type = ref('')
	const disabledForm = ref({
		yuangonggonghao : false,
		yuangongxingming : false,
		bumen : false,
		chuqintianshu : false,
		qingjiatianshu : false,
		chidaotianshu : false,
		zaotuicishu : false,
		queqintianshu : false,
		tongjishijian : false,
		zhuanyuanzhanghao : false,
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
		yuangonggonghao: [
			{required: true,message: '请输入',trigger: 'blur'}, 
		],
		yuangongxingming: [
		],
		bumen: [
		],
		chuqintianshu: [
			{required: true,message: '请输入',trigger: 'blur'}, 
			{ validator: validateIntNumber, trigger: 'blur' },
		],
		qingjiatianshu: [
			{required: true,message: '请输入',trigger: 'blur'}, 
			{ validator: validateIntNumber, trigger: 'blur' },
		],
		chidaotianshu: [
			{required: true,message: '请输入',trigger: 'blur'}, 
			{ validator: validateIntNumber, trigger: 'blur' },
		],
		zaotuicishu: [
			{required: true,message: '请输入',trigger: 'blur'}, 
			{ validator: validateIntNumber, trigger: 'blur' },
		],
		queqintianshu: [
			{required: true,message: '请输入',trigger: 'blur'}, 
			{ validator: validateIntNumber, trigger: 'blur' },
		],
		tongjishijian: [
		],
		zhuanyuanzhanghao: [
		],
	})
	//员工工号列表
	const yuangonggonghaoLists = ref([])
	//methods

	//methods
	//获取info
	const getInfo = ()=>{
		context?.$http({
			url: `${tableName}/info/${id.value}`,
			method: 'get'
		}).then(res => {
			let reg=new RegExp('../../../file','g')
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
			form.value.tongjishijian = context?.$toolUtil.getCurDateTime()
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
				if(x=='bumen'){
					form.value.bumen = row[x];
					disabledForm.value.bumen = true;
					continue;
				}
				if(x=='chuqintianshu'){
					form.value.chuqintianshu = row[x];
					disabledForm.value.chuqintianshu = true;
					continue;
				}
				if(x=='qingjiatianshu'){
					form.value.qingjiatianshu = row[x];
					disabledForm.value.qingjiatianshu = true;
					continue;
				}
				if(x=='chidaotianshu'){
					form.value.chidaotianshu = row[x];
					disabledForm.value.chidaotianshu = true;
					continue;
				}
				if(x=='zaotuicishu'){
					form.value.zaotuicishu = row[x];
					disabledForm.value.zaotuicishu = true;
					continue;
				}
				if(x=='queqintianshu'){
					form.value.queqintianshu = row[x];
					disabledForm.value.queqintianshu = true;
					continue;
				}
				if(x=='tongjishijian'){
					form.value.tongjishijian = row[x];
					disabledForm.value.tongjishijian = true;
					continue;
				}
				if(x=='zhuanyuanzhanghao'){
					form.value.zhuanyuanzhanghao = row[x];
					disabledForm.value.zhuanyuanzhanghao = true;
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
		disabledForm.value.bumen = true;
	}
	//初始化
	//取消
	const backClick = () => {
		history.back()
	}
	//员工工号回调
	const yuangonggonghaoChange=()=>{
		context?.$http({
			url: `follow/yuangong/yuangonggonghao?columnValue=` + form.value.yuangonggonghao,
			method: 'get'
		}).then(res=>{
			//带出员工姓名字段
			if(res.data.data.yuangongxingming){
				form.value.yuangongxingming = res.data.data.yuangongxingming
			}
			//带出部门字段
			if(res.data.data.bumen){
				form.value.bumen = res.data.data.bumen
			}
		})
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
				//日期选择器
				.list_date {
					border-radius: 0px;
					background: #fff;
					width: auto;
					border-color: #ccc;
					border-width: 1px;
					line-height: 36px;
					box-sizing: border-box;
					border-style: solid;
					min-width: 100%;
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