<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/import/import.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ctx}/static/css/global.css">
<link rel="stylesheet" href="${ctx}/static/css/popup.css">
<link rel="stylesheet" href="${ctx}/static/css/magnific-popup.css">
<link rel="stylesheet" href="${ctx}/static/css/living.css">
<link rel="stylesheet" href="${ctx}/static/css/main.css"> 
</head>
<body>
<div id="content">

<div style="background-color: #e9ecef;">
				<div class="g_menu_area">
					<ul id="gnb_menu_layer" class="co_menu" style="margin-left: 0px;">
					<li  menu-code="HOME" ext-mode="Y" class="co_lnb_home">
						<a href="http://pc.shopping2.naver.com/home/p/index.nhn" class="N=a:LNB.home"><font>产品</font></em></a><!--N=a:LNB.home-->
					</li>
					<li menu-code="TMSP" ext-mode="Y" class="co_lnb_theme">
						<a href="${ctx}/static/jsp/introduction.jsp" class="N=a:LNB.theme"><em><font>品牌介绍</font></em></a><!--N=a:LNB.theme-->
					</li>
					<li menu-code="DEPT" ext-mode="N" class="co_lnb_depart">
						<a href="/department/home" class="N=a:LNB.wdep "><em><font>其他</font></em></a><!--N=a:LNB.wdep-->
					</li>
					</ul>
					
					<a href="#" role="button" class="g_btn_prev"><em><span>왼쪽으로 이동</span></em></a>
					<a href="#" role="button" class="g_btn_next"><em><span>오른쪽으로 이동</span></em></a>
				</div>
				
				<div class="wrap clearfix _sideRollRoot">
		<div class="common_header no_border">
			<div class="banner">
					<img class="common_img_center" src="http://shop1.phinf.naver.net/20170526_84/showindowCommon_1495782172570CCTsh_JPEG/1104196795062737_-1040738293.jpg?type=f324_180" alt="한국의 미가 돋보여요~">
				<div class="common_border"></div>
			</div>
			<h3 class="info">
				<span class="slogan">테마기획</span>
				<span class="title">한국의 미가 돋보여요~</span>
				<span class="desc">2017.05.29.(월) ~ 2017.06.11.(일)</span>
				<span class="mask"></span>
			</h3>
		</div>
		
		
        <div class="common_list_title COLLECTION_TITLE" style="display: block;">
            <h3 class="title">降火的菊花茶</h3>
        </div>
        





<ul id="1000417406" class="common_list_static NO_TAP_HIGHLIGHT COLLECTION_LIST" style="display: block; position: relative; ">
<!-- ItemLayout vs NewItemlayout  -->

	<c:forEach items="${productions}" var="p">
	<li class="list default item  img_full_h _NEW_ITEM_LAYOUT" style="position: relative; left: 0px; top: 0px;">
		<a class="link N=a:end.item,i:1000824025" href="${ctx}/production/detail/1">
			<div class="thumb">
				<span class="thumb_img">
					<img class="img" src="${ctx}/static/img/mum_01.jpg" alt="0.654">
				</span>
					<div class="price">
						<i class="bg"></i>
						<strong class="value"><em class="number">${p.price}</em>元</strong>
					</div>
					<div class="common_border"></div>
			</div>
			<div class="flag best text_indent">Best</div>
			<dl class="goods_desc">
            	<dt class="tit">${p.name }</dt>
            	<dd class="dsc">${p.briefIntroduction}</dd>
            </dl>
			
			<div class="count">
				<ul class="count_list">
					<li class="list view">
						<i class="title text_indent">뷰</i><em class="number">${p.sales}</em>
					</li>
				
				<li class="list talk">
					<i class="title text_indent">톡</i>
				</li>
				</ul>
			</div>
		</a>
		
	</li>
	</c:forEach>
	<%-- <li class="list default item  img_full_h _NEW_ITEM_LAYOUT" style="position: relative; left: 0px; top: 0px;">
		<a class="link N=a:end.item,i:1000824025" href="${ctx}/production/detail/1">
			<div class="thumb">
				<span class="thumb_img">
					<img class="img" src="${ctx}/static/img/mum_01.jpg" alt="0.654">
				</span>
					<div class="price">
						<i class="bg"></i>
						<strong class="value"><em class="number">10,000</em>원</strong>
					</div>
					<div class="common_border"></div>
			</div>
			<div class="flag best text_indent">Best</div>
			<dl class="goods_desc">
            	<dt class="tit">[하늘빚다 도자기] 한옥 수저받침 / 도자기 수저받침</dt>
            	<dd class="dsc">따듯한 집 밥에 더욱 잘 어울리는핸드메이드 도자기 수저받침 입니다.♥</dd>
            </dl>
			
			<div class="count">
				<ul class="count_list">
					<li class="list view">
						<i class="title text_indent">뷰</i><em class="number">5,433</em>
					</li>
				<li class="list scrap">
					<i class="title text_indent"></i>찜<em class="number">305</em>
				</li>
				<li class="list talk">
					<i class="title text_indent">톡</i>
				</li>
				</ul>
			</div>
		</a>
		
	</li><li class="list default item  img_full_h _NEW_ITEM_LAYOUT" style="position: relative; left: 0px; top: 0px;">
		<a class="link N=a:end.item,i:1000824025" href="${ctx}/production/detail/1">
			<div class="thumb">
				<span class="thumb_img">
					<img class="img" src="${ctx}/static/img/mum_01.jpg" alt="0.654">
				</span>
					<div class="price">
						<i class="bg"></i>
						<strong class="value"><em class="number">10,000</em>원</strong>
					</div>
					<div class="common_border"></div>
			</div>
			<div class="flag best text_indent">Best</div>
			<dl class="goods_desc">
            	<dt class="tit">[하늘빚다 도자기] 한옥 수저받침 / 도자기 수저받침</dt>
            	<dd class="dsc">따듯한 집 밥에 더욱 잘 어울리는핸드메이드 도자기 수저받침 입니다.♥</dd>
            </dl>
			
			<div class="count">
				<ul class="count_list">
					<li class="list view">
						<i class="title text_indent">뷰</i><em class="number">5,433</em>
					</li>
				<li class="list scrap">
					<i class="title text_indent"></i>찜<em class="number">305</em>
				</li>
				<li class="list talk">
					<i class="title text_indent">톡</i>
				</li>
				</ul>
			</div>
		</a>
		
	</li> --%>
	
	
	
        </ul> 
        
        
		
		
			<div id="recommend_list" style="position: relative; left: 0px; top: 0px;">
				<div class="common_list_title">
					<h3 class="title">人气产品</h3>
					
				</div>
				<div class="event_list_roll_wrap _sideRollMain">
					<ul class="event_list _sideRollScroll" style="position: relative; width: 3888px; left: 0px;">
							<li class="list _sideRollItem">
								<a class="link N=a:end.bevent" href="/living/specialEvent/detail/6757">
									<strong class="title">밤의 온도를 높이는 조명</strong>
									<span class="desc">인테리어 조명</span>
									<div class="thumb">
											<img class="common_img_center size_ratio" src="http://shop1.phinf.naver.net/20170605_243/showindowCommon_14966587037290OAWM_JPEG/33263634080546167_208390622.jpg?type=w304" alt="밤의 온도를 높이는 조명">
										<div class="common_border"></div>
									</div>
								</a>
							</li>
							<li class="list _sideRollItem">
								<a class="link N=a:end.bevent" href="/living/specialEvent/detail/6649">
									<strong class="title">직접 느끼는 핸드워크~</strong>
									<span class="desc">수예품 아이템</span>
									<div class="thumb">
											<img class="common_img_center size_ratio" src="http://shop1.phinf.naver.net/20170604_168/showindowCommon_1496574522043dVFFo_JPEG/33179452393195048_-1822476886.jpg?type=w304" alt="직접 느끼는 핸드워크~">
										<div class="common_border"></div>
									</div>
								</a>
							</li>
							<li class="list _sideRollItem">
								<a class="link N=a:end.bevent" href="/living/specialEvent/detail/6648">
									<strong class="title">완벽한 정리정돈의 비결!</strong>
									<span class="desc">수납가구 구경해요!</span>
									<div class="thumb">
											<img class="common_img_center size_ratio" src="http://shop1.phinf.naver.net/20170602_148/showindowCommon_1496390396767t4nIM_JPEG/1712420991934486_1059192740.jpg?type=w304" alt="완벽한 정리정돈의 비결!">
										<div class="common_border"></div>
									</div>
								</a>
							</li>
							<li class="list _sideRollItem">
								<a class="link N=a:end.bevent" href="/living/specialEvent/detail/6633">
									<strong class="title">지난 주 사랑받은 NEW 아이템</strong>
									<span class="desc">5월4주 신상품 BEST!</span>
									<div class="thumb">
											<img class="common_img_center size_ratio" src="http://shop1.phinf.naver.net/20170530_227/showindowCommon_1496142408956f9tNE_JPEG/1464433182921325_564314018.jpg?type=w304" alt="지난 주 사랑받은 NEW 아이템">
										<div class="common_border"></div>
									</div>
								</a>
							</li>
							<li class="list _sideRollItem">
								<a class="link N=a:end.bevent" href="/living/specialEvent/detail/6625">
									<strong class="title">가보고 싶던 플리마켓을 쉽게 즐겨요~</strong>
									<span class="desc">누구에게나</span>
									<div class="thumb">
											<img class="common_img_center size_ratio" src="http://shop1.phinf.naver.net/20170601_213/showindowCommon_1496300858172M0iNl_JPEG/1622882287408549_-2041074881.jpg?type=w304" alt="가보고 싶던 플리마켓을 쉽게 즐겨요~">
										<div class="common_border"></div>
									</div>
								</a>
							</li>
							<li class="list _sideRollItem">
								<a class="link N=a:end.bevent" href="/living/specialEvent/detail/6624">
									<strong class="title">깨끗한 모던함이란 이런 것</strong>
									<span class="desc">화이트 가구</span>
									<div class="thumb">
											<img class="common_img_center size_ratio" src="http://shop1.phinf.naver.net/20170601_240/showindowCommon_1496297562568ai6Xs_JPEG/32902492909386490_2032450219.jpg?type=w304" alt="깨끗한 모던함이란 이런 것">
										<div class="common_border"></div>
									</div>
								</a>
							</li>
							<li class="list _sideRollItem">
								<a class="link N=a:end.bevent" href="/living/specialEvent/detail/6618">
									<strong class="title">발상의 전환, 아이디어 인테리어</strong>
									<span class="desc">이 아이디어 실화!?</span>
									<div class="thumb">
											<img class="common_img_center size_ratio" src="http://shop1.phinf.naver.net/20170529_285/showindowCommon_1496055485115X1nNx_JPEG/32660415464895525_-641852689.jpg?type=w304" alt="발상의 전환, 아이디어 인테리어">
										<div class="common_border"></div>
									</div>
								</a>
							</li>
							<li class="list _sideRollItem">
								<a class="link N=a:end.bevent" href="/living/specialEvent/detail/6587">
									<strong class="title">어디에서도 볼수 없었던 김성훈도자기 실속 구성!</strong>
									<span class="desc">네이버 단독 사은품 추가 증정!</span>
									<div class="thumb">
											<img class="common_img_center size_ratio" src="http://shop1.phinf.naver.net/20170530_63/showindowCommon_1496108378966rBCQ8_JPEG/34880674X340.jpg?type=w304" alt="어디에서도 볼수 없었던 김성훈도자기 실속 구성!">
										<div class="common_border"></div>
									</div>
								</a>
							</li>
							<li class="list _sideRollItem">
								<a class="link N=a:end.bevent" href="/living/specialEvent/detail/6571">
									<strong class="title">한 땀 한 땀 정성으로 만든 패브릭</strong>
									<span class="desc">감성이 느껴져요~</span>
									<div class="thumb">
											<img class="common_img_center size_ratio" src="http://shop1.phinf.naver.net/20170530_247/showindowCommon_1496128367652cF6is_JPEG/1450391876044281_1488193247.jpg?type=w304" alt="한 땀 한 땀 정성으로 만든 패브릭">
										<div class="common_border"></div>
									</div>
								</a>
							</li>
							<li class="list _sideRollItem">
								<a class="link N=a:end.bevent" href="/living/specialEvent/detail/6570">
									<strong class="title">꽃이 스며든 인테리어 아이템</strong>
									<span class="desc">꽃향기가 날 것 같아요~</span>
									<div class="thumb">
											<img class="common_img_center size_ratio" src="http://shop1.phinf.naver.net/20170530_71/showindowCommon_1496120360065rAb4I_JPEG/32725290415651817_-613302912.jpg?type=w304" alt="꽃이 스며든 인테리어 아이템">
										<div class="common_border"></div>
									</div>
								</a>
							</li>
							<li class="list _sideRollItem">
								<a class="link N=a:end.bevent" href="/living/specialEvent/detail/6525">
									<strong class="title">테이블 위의 연장</strong>
									<span class="desc">커트러리 </span>
									<div class="thumb">
											<img class="common_img_center size_ratio" src="http://shop1.phinf.naver.net/20170526_89/showindowCommon_1495779238056TAxEO_JPEG/1101262277794162_-858397031.jpg?type=w304" alt="테이블 위의 연장">
										<div class="common_border"></div>
									</div>
								</a>
							</li>
							<li class="list _sideRollItem">
								<a class="link N=a:end.bevent" href="/living/specialEvent/detail/6498">
									<strong class="title">테이블 세팅 어렵지 않아요</strong>
									<span class="desc">간결하고 심플한 멋</span>
									<div class="thumb">
											<img class="common_img_center size_ratio" src="http://shop1.phinf.naver.net/20170525_283/showindowCommon_1495695671084CDgeU_JPEG/1017695304373784_-249958956.jpg?type=w304" alt="테이블 세팅 어렵지 않아요">
										<div class="common_border"></div>
									</div>
								</a>
							</li> 
					</ul>
				</div>
			</div>
		
	</div>

</div>
</div>
</body>
</html>