（函数（$）{
	$ .fn.lazyload =函数（选项）{
		var settings = {
			阈值：0，
			failurelimit：0，
			事件：“滚动”，
			大意是：“秀”，
			集装箱：窗口
	};
		如果（选项）{
			$ .extend（设置，选项）;
		}
		var elements = this;

		如果（ “滚动” == settings.event）{
			$（settings.container）.bind（“scroll”，function（event）{
				var counter = 0;
				elements.each（函数（）{
					如果（$。abovethetop（这一点，设置）|| $ .leftofbegin（这一点，设置））
				{} else if（！$。belowthefold（this，settings）&&！$。rightoffold（this，settings））{
						$（本）.trigger（ “显示”）;
					}其他{
						if（counter ++> settings.failurelimit）{
							返回false;
						}
					}
				}）;
				var temp = $ .grep（elements，function（element）{
					return！element.loaded;
				}）;
				elements = $（temp）;
			}）;
		}

		this.each（函数（）{

			var self = this;

			如果（未定义== $（个体经营）.attr（ “原始”））{
				$（self）.attr（“original”，$（self）.attr（“src”））;
			} if（“scroll”！= settings.event || undefined == $（self）.attr（“src”）||“”== $（self）.attr（“src”）|| settings.placeholder = = $（self）.attr（“src”）||（$。abovethetop（self，settings）|| $ .leftofbegin（self，settings）|| $ .belowthefold（self，settings）|| $ .rightoffold（self ，设置）））{
				如果（settings.placeholder）{
					$（self）.attr（“src”，settings.placeholder）;} else {$（self）.removeAttr（“src”）;
				}
				self.loaded = FALSE;
			}其他{
				self.loaded = TRUE;
			}

			$（self）.one（“出现”，function（）{
				if（！this.loaded || 1 == 1）{
					$（“<img />”）。bind（“load”，function（）{
						$（self）.hide（）。attr（“src”，$（self）.attr（“original”））[settings.effect]（settings.effectspeed）;
						self.loaded = TRUE;
					}）。attr（“src”，$（self）.attr（“original”））;
				};
			}）;

			如果（ “滚动”！= settings.event）{
				$（self）.bind（settings.event，function（event）{
					如果（！self.loaded）{
						$（个体经营）.trigger（ “显示”）;
					}
				}

		）;}
		}）;

		$（settings.container）.trigger（settings.event）;
		归还这个;
	};

	$ .belowthefold =函数（元件，设置）{
		if（settings.container === undefined || settings.container === window）{
			var fold = $（window）.height（）+ $（window）.scrollTop（）;
		}其他{
			var fold = $（settings.container）.offset（）。top + $（settings.container）.height（）;
		}
		return fold <= $（element）.offset（）。top  -  settings.threshold;
	};

	$ .rightoffold =函数（元件，设置）{
		if（settings.container === undefined || settings.container === window）{
			var fold = $（window）.width（）+ $（window）.scrollLeft（）;
		}其他{
			var fold = $（settings.container）.offset（）。left + $（settings.container）.width（）;
		}
		return fold <= $（element）.offset（）。left  -  settings.threshold;
	};

	$ .abovethetop =函数（元件，设置）{
		if（settings.container === undefined || settings.container === window）{
			var fold = $（window）.scrollTop（）;
		}其他{
			var fold = $（settings.container）.offset（）。top;
		}
		return fold> = $（element）.offset（）。top + settings.threshold + $（element）.height（）;
	};

	$ .leftofbegin =函数（元件，设置）{
		if（settings.container === undefined || settings.container === window）{
			var fold = $（window）.scrollLeft（）;
		}其他{
			var fold = $（settings.container）.offset（）。left;
		}
		return fold> = $（element）.offset（）。left + settings.threshold + $（element）.width（）;
	};

	$ .extend（
		$ .expr [ '：']，
		{
		“低于折叠”：“$ .belowthefold（a，{threshold：0，container：window}）”，
		“首付”：“！$。在thefold下面（a，{threshold：0，container：window}）”，
		“折叠权”：“$ .rightoffold（a，{threshold：0，container：window}）”，
		“left-of-fold”：“！$。rightoffold（a，{threshold：0，container：window}）”
		}
	）;

}）（jQuery的）;