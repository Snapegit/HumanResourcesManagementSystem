<template>
	<div>
		<div class="register_view">
			<el-form :model="registerForm" class="register_form">
				<div class="title_view">{{projectName}}注册</div>
				<div class="list_item">
					<div class="list_label">专员账号：</div>
					<input class="list_inp"
					 v-model="registerForm.zhuanyuanzhanghao" 
					 placeholder="请输入专员账号"
					 type="text"
					 />
				</div>
				<div class="list_item">
					<div class="list_label">密码：</div>
					<input class="list_inp"
					 v-model="registerForm.mima" 
					 placeholder="请输入密码"
					 type="password"
					 />
				</div>
				<div class="list_item">
					<div class="list_label">确认密码：</div>
					<input class="list_inp" v-model="registerForm.mima2" type="password" placeholder="请输入确认密码" />
				</div>
				<div class="list_item">
					<div class="list_label">专员名称：</div>
					<input class="list_inp"
					 v-model="registerForm.zhuanyuanmingcheng" 
					 placeholder="请输入专员名称"
					 type="text"
					 />
				</div>
				<div class="list_item">
					<div class="list_label">封面：</div>
					<div class="list_file_list">
						<uploads
							action="file/upload" 
							tip="请上传封面" 
							:limit="3" 
							style="width: 100%;text-align: left;"
							:fileUrls="registerForm.fengmian?registerForm.fengmian:''" 
							@change="fengmianUploadSuccess">
						</uploads>
					</div>
				</div>
				<div class="list_item">
					<div class="list_label">联系电话：</div>
					<input class="list_inp"
					 v-model="registerForm.lianxidianhua" 
					 placeholder="请输入联系电话"
					 type="text"
					 />
				</div>
				<div class="list_btn">
					<el-button class="register" type="success" @click="handleRegister">注册</el-button>
					<div class="r-login" @click="close">已有账号，直接登录</div>
				</div>
			</el-form>	
		</div>
	</div>
</template>
<script setup>
	import {
		ref,
		getCurrentInstance,
		nextTick,
	} from 'vue';
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	const projectName = context?.$project.projectName
	//获取注册类型
	import { useRoute } from 'vue-router';
	const route = useRoute()
	const tableName = ref('renshizhuanyuan')
	
	
	const registerForm = ref({
         sfsh: '待审核',
	})
	const init=()=>{
	}
    const fengmianUploadSuccess=(fileUrls)=> {
        registerForm.value.fengmian = fileUrls;
    }
	// 多级联动参数
	//注册按钮
	const handleRegister = () => {
		let url = tableName.value +"/register";
		if((!registerForm.value.zhuanyuanzhanghao)){
			context?.$toolUtil.message(`专员账号不能为空`,'error')
			return false
		}
		if((!registerForm.value.mima)){
			context?.$toolUtil.message(`密码不能为空`,'error')
			return false
		}
		if(registerForm.value.mima!=registerForm.value.mima2){
			context?.$toolUtil.message('两次密码输入不一致','error')
			return false
		}
		if((!registerForm.value.zhuanyuanmingcheng)){
			context?.$toolUtil.message(`专员名称不能为空`,'error')
			return false
		}
		if(registerForm.value.fengmian!=null){
			registerForm.value.fengmian = registerForm.value.fengmian.replace(new RegExp(context?.$config.url,"g"),"");
		}
		if(registerForm.value.lianxidianhua&&(!context?.$toolUtil.isMobile(registerForm.value.lianxidianhua))){
			context?.$toolUtil.message(`联系电话应输入手机格式`,'error')
			return false
		}
		
		context?.$http({
			url:url,
			method:'post',
			data:registerForm.value
		}).then(res=>{
			context?.$toolUtil.message('注册成功','success', obj=>{
				context?.$router.push({
					path: "/login"
				});
			})
		})
	}
	//公共方法
	const getUUID=()=> {
		return new Date().getTime();
	}
	//返回登录
	const close = () => {
		context?.$router.push({
			path: "/login"
		});
	}
	init()
</script>
<style lang="scss" scoped>
	.register_view {
		background-repeat: no-repeat;
		flex-direction: column;
		background-size: cover;
		background: url(http://clfile.zggen.cn/20231215/1fb961fae2f94d149038648724b01b3e.jpg);
		display: flex;
		min-height: 100vh;
		justify-content: center;
		align-items: flex-end;
		position: relative;
		background-position: center center;
		// 表单盒子
		.register_form {
			border-radius: 0px;
			padding: 40px 60px 40px 40px;
			margin: 0;
			flex-direction: column;
			background: #fff;
			display: flex;
			width: 32vw;
			min-height: 100vh;
			justify-content: center;
			align-items: center;
			flex-wrap: wrap;
		}
		// 标题样式
		.title_view {
			padding: 0 0 20px;
			margin: 0 0 0 90px;
			color: #3f3f3f;
			background: #fff;
			width: calc(100% - 90px);
			font-size: 20px;
			text-align: center;
		}
		// item盒子
		.list_item {
			margin: 0 0 12px;
			display: flex;
			width: 100%;
			justify-content: flex-start;
			align-items: center;
			// label
			.list_label {
				color: #333;
				width: 120px;
				font-size: 14px;
				box-sizing: border-box;
				text-align: right;
			}
			// 输入框
			:deep(.list_inp) {
				border: 1px solid #ddd;
				border-radius: 0px;
				padding: 0 10px;
				color: #666;
				background: none;
				width: calc(100% - 100px);
				border-width: 0 0 1px;
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
		}
		//图片上传样式
		.list_file_list  {
			//提示语
			:deep(.el-upload__tip){
				margin: 7px 0 0;
				color: #333;
				display: flex;
				font-size: 14px;
				justify-content: flex-start;
				align-items: center;
			}
			//外部盒子
			:deep(.el-upload--picture-card){
				border: 1px solid #ddd;
				cursor: pointer;
				border-radius: 0px;
				color: #fff;
				background: none;
				width: 120px;
				line-height: 48px;
				text-align: center;
				height: 44px;
				//图标
				.el-icon{
					color: #ddd;
					font-weight: 600;
					font-size: 24px;
				}
			}
			:deep(.el-upload-list__item) {
				border: 1px solid #ddd;
				cursor: pointer;
				border-radius: 0px;
				color: #fff;
				background: none;
				width: 120px;
				line-height: 48px;
				text-align: center;
				height: 44px;
			}
		}
		//按钮盒子
		.list_btn {
			margin: 20px 0 0;
			display: flex;
			width: 100%;
			justify-content: flex-end;
			align-items: center;
			flex-wrap: wrap;
			//注册按钮
			.register {
					border: none;
					border-radius: 0px;
					color: #fff;
					background: #ef4238;
					width: calc(100% - 120px);
					font-size: 16px;
					height: 40px;
			}
			//注册按钮悬浮样式
			.register:hover {
				border: none;
				border-radius: 0px;
				background: #ef4238;
				width: calc(100% - 120px);
				font-size: 16px;
				opacity: 1;
				height: 40px;
			}
			//已有账号
			.r-login {
				cursor: pointer;
				padding: 20px 0 0 80px;
				color: #666;
				width: 80%;
				font-size: 14px;
				text-align: right;
			}
		}
	}
</style>