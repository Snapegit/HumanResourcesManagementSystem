import { createRouter, createWebHashHistory } from 'vue-router'
import index from '../views'
import home from '../views/pages/home.vue'
import login from '../views/pages/login.vue'
import yonghuList from '@/views/pages/yonghu/list'
import yonghuDetail from '@/views/pages/yonghu/formModel'
import yonghuAdd from '@/views/pages/yonghu/formAdd'
import yonghuRegister from '@/views/pages/yonghu/register'
import yonghuCenter from '@/views/pages/yonghu/center'
import renshizhuanyuanList from '@/views/pages/renshizhuanyuan/list'
import renshizhuanyuanDetail from '@/views/pages/renshizhuanyuan/formModel'
import renshizhuanyuanAdd from '@/views/pages/renshizhuanyuan/formAdd'
import gangweileixingList from '@/views/pages/gangweileixing/list'
import gangweileixingDetail from '@/views/pages/gangweileixing/formModel'
import gangweileixingAdd from '@/views/pages/gangweileixing/formAdd'
import zhaopinxinxiList from '@/views/pages/zhaopinxinxi/list'
import zhaopinxinxiDetail from '@/views/pages/zhaopinxinxi/formModel'
import zhaopinxinxiAdd from '@/views/pages/zhaopinxinxi/formAdd'
import storeupList from '@/views/pages/storeup/list'
import toudijianliList from '@/views/pages/toudijianli/list'
import toudijianliDetail from '@/views/pages/toudijianli/formModel'
import toudijianliAdd from '@/views/pages/toudijianli/formAdd'
import mianshitongzhiList from '@/views/pages/mianshitongzhi/list'
import mianshitongzhiDetail from '@/views/pages/mianshitongzhi/formModel'
import mianshitongzhiAdd from '@/views/pages/mianshitongzhi/formAdd'
import newsList from '@/views/pages/news/list'
import syslogList from '@/views/pages/syslog/list'
import syslogDetail from '@/views/pages/syslog/formModel'
import syslogAdd from '@/views/pages/syslog/formAdd'
import yuangongList from '@/views/pages/yuangong/list'
import yuangongDetail from '@/views/pages/yuangong/formModel'
import yuangongAdd from '@/views/pages/yuangong/formAdd'
import yuangongCenter from '@/views/pages/yuangong/center'
import renshidanganList from '@/views/pages/renshidangan/list'
import renshidanganDetail from '@/views/pages/renshidangan/formModel'
import renshidanganAdd from '@/views/pages/renshidangan/formAdd'
import bumenList from '@/views/pages/bumen/list'
import bumenDetail from '@/views/pages/bumen/formModel'
import bumenAdd from '@/views/pages/bumen/formAdd'
import peixunxinxiList from '@/views/pages/peixunxinxi/list'
import peixunxinxiDetail from '@/views/pages/peixunxinxi/formModel'
import peixunxinxiAdd from '@/views/pages/peixunxinxi/formAdd'
import canjiapeixunList from '@/views/pages/canjiapeixun/list'
import canjiapeixunDetail from '@/views/pages/canjiapeixun/formModel'
import canjiapeixunAdd from '@/views/pages/canjiapeixun/formAdd'
import peixunpingjiaList from '@/views/pages/peixunpingjia/list'
import peixunpingjiaDetail from '@/views/pages/peixunpingjia/formModel'
import peixunpingjiaAdd from '@/views/pages/peixunpingjia/formAdd'
import jixiaobiaozhunList from '@/views/pages/jixiaobiaozhun/list'
import jixiaobiaozhunDetail from '@/views/pages/jixiaobiaozhun/formModel'
import jixiaobiaozhunAdd from '@/views/pages/jixiaobiaozhun/formAdd'
import qingjiaxiujiaList from '@/views/pages/qingjiaxiujia/list'
import qingjiaxiujiaDetail from '@/views/pages/qingjiaxiujia/formModel'
import qingjiaxiujiaAdd from '@/views/pages/qingjiaxiujia/formAdd'
import jiabanshenqingList from '@/views/pages/jiabanshenqing/list'
import jiabanshenqingDetail from '@/views/pages/jiabanshenqing/formModel'
import jiabanshenqingAdd from '@/views/pages/jiabanshenqing/formAdd'
import gangweidiaohuanList from '@/views/pages/gangweidiaohuan/list'
import gangweidiaohuanDetail from '@/views/pages/gangweidiaohuan/formModel'
import gangweidiaohuanAdd from '@/views/pages/gangweidiaohuan/formAdd'
import gongzixinxiList from '@/views/pages/gongzixinxi/list'
import gongzixinxiDetail from '@/views/pages/gongzixinxi/formModel'
import gongzixinxiAdd from '@/views/pages/gongzixinxi/formAdd'
import dakaxinxiList from '@/views/pages/dakaxinxi/list'
import dakaxinxiDetail from '@/views/pages/dakaxinxi/formModel'
import dakaxinxiAdd from '@/views/pages/dakaxinxi/formAdd'
import kaoqinxinxiList from '@/views/pages/kaoqinxinxi/list'
import kaoqinxinxiDetail from '@/views/pages/kaoqinxinxi/formModel'
import kaoqinxinxiAdd from '@/views/pages/kaoqinxinxi/formAdd'
import jixiaokaoheList from '@/views/pages/jixiaokaohe/list'
import jixiaokaoheDetail from '@/views/pages/jixiaokaohe/formModel'
import jixiaokaoheAdd from '@/views/pages/jixiaokaohe/formAdd'
import xinchoubiaozhunList from '@/views/pages/xinchoubiaozhun/list'
import xinchoubiaozhunDetail from '@/views/pages/xinchoubiaozhun/formModel'
import xinchoubiaozhunAdd from '@/views/pages/xinchoubiaozhun/formAdd'
import gongzuojiluList from '@/views/pages/gongzuojilu/list'
import gongzuojiluDetail from '@/views/pages/gongzuojilu/formModel'
import gongzuojiluAdd from '@/views/pages/gongzuojilu/formAdd'

const routes = [{
		path: '/',
		redirect: '/index/home'
	},
	{
		path: '/index',
		component: index,
		children: [{
			path: 'home',
			component: home
		}
		, {
			path: 'yonghuList',
			component: yonghuList
		}, {
			path: 'yonghuDetail',
			component: yonghuDetail
		}, {
			path: 'yonghuAdd',
			component: yonghuAdd
		}
		, {
			path: 'yonghuCenter',
			component: yonghuCenter
		}
		, {
			path: 'renshizhuanyuanList',
			component: renshizhuanyuanList
		}, {
			path: 'renshizhuanyuanDetail',
			component: renshizhuanyuanDetail
		}, {
			path: 'renshizhuanyuanAdd',
			component: renshizhuanyuanAdd
		}
		, {
			path: 'gangweileixingList',
			component: gangweileixingList
		}, {
			path: 'gangweileixingDetail',
			component: gangweileixingDetail
		}, {
			path: 'gangweileixingAdd',
			component: gangweileixingAdd
		}
		, {
			path: 'zhaopinxinxiList',
			component: zhaopinxinxiList
		}, {
			path: 'zhaopinxinxiDetail',
			component: zhaopinxinxiDetail
		}, {
			path: 'zhaopinxinxiAdd',
			component: zhaopinxinxiAdd
		}
		, {
			path: 'storeupList',
			component: storeupList
		}
		, {
			path: 'toudijianliList',
			component: toudijianliList
		}, {
			path: 'toudijianliDetail',
			component: toudijianliDetail
		}, {
			path: 'toudijianliAdd',
			component: toudijianliAdd
		}
		, {
			path: 'mianshitongzhiList',
			component: mianshitongzhiList
		}, {
			path: 'mianshitongzhiDetail',
			component: mianshitongzhiDetail
		}, {
			path: 'mianshitongzhiAdd',
			component: mianshitongzhiAdd
		}
		, {
			path: 'newsList',
			component: newsList
		}
		, {
			path: 'syslogList',
			component: syslogList
		}, {
			path: 'syslogDetail',
			component: syslogDetail
		}, {
			path: 'syslogAdd',
			component: syslogAdd
		}
		, {
			path: 'yuangongList',
			component: yuangongList
		}, {
			path: 'yuangongDetail',
			component: yuangongDetail
		}, {
			path: 'yuangongAdd',
			component: yuangongAdd
		}
		, {
			path: 'yuangongCenter',
			component: yuangongCenter
		}
		, {
			path: 'renshidanganList',
			component: renshidanganList
		}, {
			path: 'renshidanganDetail',
			component: renshidanganDetail
		}, {
			path: 'renshidanganAdd',
			component: renshidanganAdd
		}
		, {
			path: 'bumenList',
			component: bumenList
		}, {
			path: 'bumenDetail',
			component: bumenDetail
		}, {
			path: 'bumenAdd',
			component: bumenAdd
		}
		, {
			path: 'peixunxinxiList',
			component: peixunxinxiList
		}, {
			path: 'peixunxinxiDetail',
			component: peixunxinxiDetail
		}, {
			path: 'peixunxinxiAdd',
			component: peixunxinxiAdd
		}
		, {
			path: 'canjiapeixunList',
			component: canjiapeixunList
		}, {
			path: 'canjiapeixunDetail',
			component: canjiapeixunDetail
		}, {
			path: 'canjiapeixunAdd',
			component: canjiapeixunAdd
		}
		, {
			path: 'peixunpingjiaList',
			component: peixunpingjiaList
		}, {
			path: 'peixunpingjiaDetail',
			component: peixunpingjiaDetail
		}, {
			path: 'peixunpingjiaAdd',
			component: peixunpingjiaAdd
		}
		, {
			path: 'jixiaobiaozhunList',
			component: jixiaobiaozhunList
		}, {
			path: 'jixiaobiaozhunDetail',
			component: jixiaobiaozhunDetail
		}, {
			path: 'jixiaobiaozhunAdd',
			component: jixiaobiaozhunAdd
		}
		, {
			path: 'qingjiaxiujiaList',
			component: qingjiaxiujiaList
		}, {
			path: 'qingjiaxiujiaDetail',
			component: qingjiaxiujiaDetail
		}, {
			path: 'qingjiaxiujiaAdd',
			component: qingjiaxiujiaAdd
		}
		, {
			path: 'jiabanshenqingList',
			component: jiabanshenqingList
		}, {
			path: 'jiabanshenqingDetail',
			component: jiabanshenqingDetail
		}, {
			path: 'jiabanshenqingAdd',
			component: jiabanshenqingAdd
		}
		, {
			path: 'gangweidiaohuanList',
			component: gangweidiaohuanList
		}, {
			path: 'gangweidiaohuanDetail',
			component: gangweidiaohuanDetail
		}, {
			path: 'gangweidiaohuanAdd',
			component: gangweidiaohuanAdd
		}
		, {
			path: 'gongzixinxiList',
			component: gongzixinxiList
		}, {
			path: 'gongzixinxiDetail',
			component: gongzixinxiDetail
		}, {
			path: 'gongzixinxiAdd',
			component: gongzixinxiAdd
		}
		, {
			path: 'dakaxinxiList',
			component: dakaxinxiList
		}, {
			path: 'dakaxinxiDetail',
			component: dakaxinxiDetail
		}, {
			path: 'dakaxinxiAdd',
			component: dakaxinxiAdd
		}
		, {
			path: 'kaoqinxinxiList',
			component: kaoqinxinxiList
		}, {
			path: 'kaoqinxinxiDetail',
			component: kaoqinxinxiDetail
		}, {
			path: 'kaoqinxinxiAdd',
			component: kaoqinxinxiAdd
		}
		, {
			path: 'jixiaokaoheList',
			component: jixiaokaoheList
		}, {
			path: 'jixiaokaoheDetail',
			component: jixiaokaoheDetail
		}, {
			path: 'jixiaokaoheAdd',
			component: jixiaokaoheAdd
		}
		, {
			path: 'xinchoubiaozhunList',
			component: xinchoubiaozhunList
		}, {
			path: 'xinchoubiaozhunDetail',
			component: xinchoubiaozhunDetail
		}, {
			path: 'xinchoubiaozhunAdd',
			component: xinchoubiaozhunAdd
		}
		, {
			path: 'gongzuojiluList',
			component: gongzuojiluList
		}, {
			path: 'gongzuojiluDetail',
			component: gongzuojiluDetail
		}, {
			path: 'gongzuojiluAdd',
			component: gongzuojiluAdd
		}
		]
	},
	{
		path: '/login',
		component: login
	}
	,{
		path: '/yonghuRegister',
		component: yonghuRegister
	}
]

const router = createRouter({
  history: createWebHashHistory(process.env.BASE_URL),
  routes
})

export default router
