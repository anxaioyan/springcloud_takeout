/ * ================================================ =
// jQuery Tabs插件1.0
//作者：chenyg@5173.com
//网址：http：//stylechen.com/jquery-tabs.html
// 2010年12月4日
// ================================================ = * /

（函数（$）{
	$ .fn.extend（{
		标签：功能（选择）{
			//澶勭悊暟暟暟
			options = $ .extend（{
				事件：'mouseover'，
				超时：0，
				auto：0，
				回调：null
			}，options）;

			var self = $（this），
				tabBox = self.children（'div.tab_box'）。children（'div'），
				menu = self.children（'ul.tab_menu'），
				items = menu.find（'li'），
				定时器;

			var tabHandle = function（elem）{
				elem.siblings（'li'）
			.removeClass（'current'）
			。结束（）
			.addClass（'current'）;

				tabBox.siblings（'div'）
			.addClass（'hide'）
			。结束（）
			.eq（elem.index（））
			.removeClass（'hide'）;
			}，

				delay = function（elem，time）{
				时间 ？setTimeout（function（）{ta​​bHandle（elem）;}，time）：tabHandle（elem）;
			}，

				start = function（）{
				if（！options.auto）返回;
				timer = setInterval（autoRun，options.auto）;
			}，

				autoRun = function（）{
				var current = menu.find（'li.current'），
						firstItem = items.eq（0），
						len = items.length，
						index = current.index（）+ 1，
						item = index === len？firstItem：current.next（'li'），
						i =指数=== len？0：索引;

				current.removeClass（'current'）;
				item.addClass（'current'）;

				tabBox.siblings（'div'）
			.addClass（'hide'）
			。结束（）
			.EQ（ⅰ）
			.removeClass（'hide'）;
			};

			items.bind（options.event，function（）{
				延迟（$（this），options.timeout）;
				if（options.callback）{
					options.callback（self）;
				}
			}）;

			if（options.auto）{
				开始（）;
				self.hover（函数（）{
					clearInterval（计时器）;
					timer = undefined;
				}，功能（）{
					开始（）;
				}）;
			}

			归还这个;
		}
	}）;
}）（jQuery的）;