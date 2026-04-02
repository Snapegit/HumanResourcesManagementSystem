import axios from 'axios'
import router from '../router/index'
import toolUtil from '@/utils/toolUtil'
import config from '@/utils/config'
import {
	ElMessage
} from 'element-plus'

const http = axios.create({
	timeout: 1000 * 86400,
	withCredentials: true,
	baseURL: process.env.VUE_APP_BASE_API,
	headers: {
		'Content-Type': 'application/json; charset=utf-8'
	}
})

// 请求拦截
http.interceptors.request.use(config => {
	const token = toolUtil.storageGet('Token')
	if (token) {
		config.headers['Token'] = token
	}
	return config
}, error => {
	return Promise.reject(error)
})

// 响应拦截
http.interceptors.response.use(
	response => {
		// 处理业务逻辑错误码
		if (response.data && response.data.code === 401) { // 401, token失效
			toolUtil.storageClear()
			ElMessage.error(response.data.msg || '登录已过期，请重新登录')
			router.push('/login')
			return Promise.reject(response)
		} else if (response.data && response.data.code === 0) {
			return response
		} else {
			ElMessage.error(response.data.msg || '请求失败')
			return Promise.reject(response)
		}
	},
	error => {
		// 关键修复：处理HTTP错误状态码
		if (error.response) {
			const status = error.response.status

			// 处理401未授权
			if (status === 401) {
				toolUtil.storageClear()
				ElMessage.error('登录已过期，请重新登录')
				// 防止重复跳转
				if (router.currentRoute.value.path !== '/login') {
					router.push({
						path: '/login',
						query: {
							redirect: router.currentRoute.value.fullPath
						}
					})
				}
				return Promise.reject(error)
			}

			// 处理403禁止访问
			if (status === 403) {
				ElMessage.error('没有权限访问')
				return Promise.reject(error)
			}

			// 处理404未找到（可能是未登录导致的）
			if (status === 404) {
				// const token = toolUtil.storageGet('Token')
				// if (!token) {
				//     // 没有token，说明未登录
				//     ElMessage.warning('请先登录')
				//     if (router.currentRoute.value.path !== '/login') {
				//         router.push('/login')
				//     }
				// } else {
				//     ElMessage.error('请求的资源不存在')
				// }
				// return Promise.reject(error)
				if (router.currentRoute.value.path !== '/login') {
					router.push('/login')
				}
				return Promise.resolve({
					data: {}
				})
			}

			// 处理500服务器错误
			if (status === 500) {
				ElMessage.error('服务器错误，请稍后再试')
				return Promise.reject(error)
			}

			// 其他错误
			ElMessage.error(error.response.data?.msg || `请求失败: ${status}`)
		} else if (error.request) {
			// 请求已发送但没有收到响应
			ElMessage.error('网络错误，请检查网络连接')
		} else {
			// 其他错误
			ElMessage.error(error.message || '请求失败')
		}

		return Promise.reject(error)
	}
)

export default http