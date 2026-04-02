	import {
		createRouter,
		createWebHashHistory
	} from 'vue-router'
	import jixiaokaohe from '@/views/jixiaokaohe/list'
	import dakaxinxi from '@/views/dakaxinxi/list'
	import yuangong from '@/views/yuangong/list'
	import syslog from '@/views/syslog/list'
	import renshizhuanyuan from '@/views/renshizhuanyuan/list'
	import peixunxinxi from '@/views/peixunxinxi/list'
	import gongzuojilu from '@/views/gongzuojilu/list'
	import yonghu from '@/views/yonghu/list'
	import canjiapeixun from '@/views/canjiapeixun/list'
	import qingjiaxiujia from '@/views/qingjiaxiujia/list'
	import news from '@/views/news/list'
	import gangweileixing from '@/views/gangweileixing/list'
	import peixunpingjia from '@/views/peixunpingjia/list'
	import renshidangan from '@/views/renshidangan/list'
	import jiabanshenqing from '@/views/jiabanshenqing/list'
	import gongzixinxi from '@/views/gongzixinxi/list'
	import xinchoubiaozhun from '@/views/xinchoubiaozhun/list'
	import zhaopinxinxi from '@/views/zhaopinxinxi/list'
	import toudijianli from '@/views/toudijianli/list'
	import jixiaobiaozhun from '@/views/jixiaobiaozhun/list'
	import bumen from '@/views/bumen/list'
	import kaoqinxinxi from '@/views/kaoqinxinxi/list'
	import gangweidiaohuan from '@/views/gangweidiaohuan/list'
	import config from '@/views/config/list'
	import mianshitongzhi from '@/views/mianshitongzhi/list'
	import renshizhuanyuanRegister from '@/views/renshizhuanyuan/register'
	import renshizhuanyuanCenter from '@/views/renshizhuanyuan/center'

export const routes = [{
		path: '/login',
		name: 'login',
		component: () => import('../views/login.vue')
	},{
		path: '/',
		name: '首页',
		component: () => import('../views/index.vue'),
		children: [{
			path: '/',
			name: '主页',
			component: () => import('../views/HomeView.vue'),
			meta: {
				affix: true
			}
		}, {
			path: '/updatepassword',
			name: '修改密码',
			component: () => import('../views/updatepassword.vue')
		}
		
		,{
			path: '/renshizhuanyuanCenter',
			name: '人事专员个人中心',
			component: renshizhuanyuanCenter
		}
		,{
			path: '/jixiaokaohe',
			name: '绩效考核',
			component: jixiaokaohe
		}
		,{
			path: '/dakaxinxi',
			name: '打卡信息',
			component: dakaxinxi
		}
		,{
			path: '/yuangong',
			name: '员工',
			component: yuangong
		}
		,{
			path: '/syslog',
			name: '操作日志',
			component: syslog
		}
		,{
			path: '/renshizhuanyuan',
			name: '人事专员',
			component: renshizhuanyuan
		}
		,{
			path: '/peixunxinxi',
			name: '培训信息',
			component: peixunxinxi
		}
		,{
			path: '/gongzuojilu',
			name: '工作记录',
			component: gongzuojilu
		}
		,{
			path: '/yonghu',
			name: '用户',
			component: yonghu
		}
		,{
			path: '/canjiapeixun',
			name: '参加培训',
			component: canjiapeixun
		}
		,{
			path: '/qingjiaxiujia',
			name: '请假休假',
			component: qingjiaxiujia
		}
		,{
			path: '/news',
			name: '公告信息',
			component: news
		}
		,{
			path: '/gangweileixing',
			name: '岗位类型',
			component: gangweileixing
		}
		,{
			path: '/peixunpingjia',
			name: '培训评价',
			component: peixunpingjia
		}
		,{
			path: '/renshidangan',
			name: '人事档案',
			component: renshidangan
		}
		,{
			path: '/jiabanshenqing',
			name: '加班申请',
			component: jiabanshenqing
		}
		,{
			path: '/gongzixinxi',
			name: '工资信息',
			component: gongzixinxi
		}
		,{
			path: '/xinchoubiaozhun',
			name: '薪酬标准',
			component: xinchoubiaozhun
		}
		,{
			path: '/zhaopinxinxi',
			name: '招聘信息',
			component: zhaopinxinxi
		}
		,{
			path: '/toudijianli',
			name: '投递简历',
			component: toudijianli
		}
		,{
			path: '/jixiaobiaozhun',
			name: '绩效标准',
			component: jixiaobiaozhun
		}
		,{
			path: '/bumen',
			name: '部门',
			component: bumen
		}
		,{
			path: '/kaoqinxinxi',
			name: '考勤信息',
			component: kaoqinxinxi
		}
		,{
			path: '/gangweidiaohuan',
			name: '岗位调换',
			component: gangweidiaohuan
		}
		,{
			path: '/config',
			name: '轮播图',
			component: config
		}
		,{
			path: '/mianshitongzhi',
			name: '面试通知',
			component: mianshitongzhi
		}
		]
	},
	{
		path: '/renshizhuanyuanRegister',
		name: '人事专员注册',
		component: renshizhuanyuanRegister
	},
]

const router = createRouter({
	history: createWebHashHistory(process.env.BASE_URL),
	routes
})

export default router
