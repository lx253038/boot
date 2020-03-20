<#assign path="${springMacroRequestContext.contextPath}">
<!DOCTYPE html>
<html class="no-js" lang="zxx">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="meta description">
    <title>全部商品</title>

    <#include "common/cssandjs.ftl">

</head>

<body>

<#include "common/header.ftl">



<!-- main wrapper start -->
<main>
    <!-- breadcrumb area start -->
    <div class="breadcrumb-area common-bg">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div style="padding:5px">

                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- breadcrumb area end -->

    <!-- page main wrapper start -->
    <div class="shop-main-wrapper section-space pb-0">
        <div class="container">
            <div class="row">
                <!-- sidebar area start -->
                <div class="col-lg-3 order-2 order-lg-1">
                    <aside class="sidebar-wrapper">
                        <!-- single sidebar start -->
                        <div class="sidebar-single">
                            <h3 class="sidebar-title">categories</h3>
                            <div class="sidebar-body">
                                <ul class="shop-categories">
                                    <li><a href="#">Jasmine <span>10</span></a></li>
                                    <li><a href="#">Rose <span>5</span></a></li>
                                    <li><a href="#">Orchid <span>8</span></a></li>
                                    <li><a href="#">Blossom <span>4</span></a></li>
                                    <li><a href="#">Hyacinth <span>5</span></a></li>
                                    <li><a href="#">Bouquet <span>2</span></a></li>
                                </ul>
                            </div>
                        </div>
                        <!-- single sidebar end -->

                        <!-- single sidebar start -->
                        <div class="sidebar-single">
                            <h3 class="sidebar-title">price</h3>
                            <div class="sidebar-body">
                                <div class="price-range-wrap">
                                    <div class="price-range" data-min="0" data-max="1000"></div>
                                    <div class="range-slider">
                                        <form action="#" class="d-flex align-items-center justify-content-between">
                                            <div class="price-input">
                                                <label for="amount">Price: </label>
                                                <input type="text" id="amount">
                                            </div>
                                            <button class="filter-btn">filter</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- single sidebar end -->

                        <!-- single sidebar start -->
                        <div class="sidebar-single">
                            <h3 class="sidebar-title">brand</h3>
                            <div class="sidebar-body">
                                <ul class="checkbox-container categories-list">
                                    <li>
                                        <div class="custom-control custom-checkbox">
                                            <input type="checkbox" class="custom-control-input" id="customCheck2">
                                            <label class="custom-control-label" for="customCheck2">Studio (3)</label>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="custom-control custom-checkbox">
                                            <input type="checkbox" class="custom-control-input" id="customCheck3">
                                            <label class="custom-control-label" for="customCheck3">Hastech (4)</label>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="custom-control custom-checkbox">
                                            <input type="checkbox" class="custom-control-input" id="customCheck4">
                                            <label class="custom-control-label" for="customCheck4">Quickiin (15)</label>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="custom-control custom-checkbox">
                                            <input type="checkbox" class="custom-control-input" id="customCheck1">
                                            <label class="custom-control-label" for="customCheck1">Graphic corner
                                                (10)</label>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="custom-control custom-checkbox">
                                            <input type="checkbox" class="custom-control-input" id="customCheck5">
                                            <label class="custom-control-label" for="customCheck5">devItems (12)</label>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <!-- single sidebar end -->

                        <!-- single sidebar start -->
                        <div class="sidebar-single">
                            <h3 class="sidebar-title">color</h3>
                            <div class="sidebar-body">
                                <ul class="checkbox-container categories-list">
                                    <li>
                                        <div class="custom-control custom-checkbox">
                                            <input type="checkbox" class="custom-control-input" id="customCheck12">
                                            <label class="custom-control-label" for="customCheck12">black (20)</label>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="custom-control custom-checkbox">
                                            <input type="checkbox" class="custom-control-input" id="customCheck13">
                                            <label class="custom-control-label" for="customCheck13">red (6)</label>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="custom-control custom-checkbox">
                                            <input type="checkbox" class="custom-control-input" id="customCheck14">
                                            <label class="custom-control-label" for="customCheck14">blue (8)</label>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="custom-control custom-checkbox">
                                            <input type="checkbox" class="custom-control-input" id="customCheck11">
                                            <label class="custom-control-label" for="customCheck11">green (5)</label>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="custom-control custom-checkbox">
                                            <input type="checkbox" class="custom-control-input" id="customCheck15">
                                            <label class="custom-control-label" for="customCheck15">pink (4)</label>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <!-- single sidebar end -->

                        <!-- single sidebar start -->
                        <div class="sidebar-single">
                            <h3 class="sidebar-title">size</h3>
                            <div class="sidebar-body">
                                <ul class="checkbox-container categories-list">
                                    <li>
                                        <div class="custom-control custom-checkbox">
                                            <input type="checkbox" class="custom-control-input" id="customCheck111">
                                            <label class="custom-control-label" for="customCheck111">S (4)</label>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="custom-control custom-checkbox">
                                            <input type="checkbox" class="custom-control-input" id="customCheck222">
                                            <label class="custom-control-label" for="customCheck222">M (5)</label>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="custom-control custom-checkbox">
                                            <input type="checkbox" class="custom-control-input" id="customCheck333">
                                            <label class="custom-control-label" for="customCheck333">L (7)</label>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="custom-control custom-checkbox">
                                            <input type="checkbox" class="custom-control-input" id="customCheck444">
                                            <label class="custom-control-label" for="customCheck444">XL (3)</label>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <!-- single sidebar end -->

                        <!-- single sidebar start -->
                        <div class="sidebar-banner">
                            <div class="img-container">
                                <a href="#">
                                    <img src="${path}/static/assets/img/banner/sidebar-banner.jpg" alt="">
                                </a>
                            </div>
                        </div>
                        <!-- single sidebar end -->
                    </aside>
                </div>
                <!-- sidebar area end -->

                <!-- shop main wrapper start -->
                <div class="col-lg-9 order-1 order-lg-2">
                    <div class="shop-product-wrapper">
                        <!-- shop product top wrap start -->
                        <div class="shop-top-bar">
                            <div class="row align-items-center">
                                <div class="col-lg-7 col-md-6 order-2 order-md-1">
                                    <div class="top-bar-left">
                                        <div class="product-view-mode">
                                            <a class="active" href="#" data-target="grid-view" data-toggle="tooltip"
                                               title="Grid View"><i class="fa fa-th"></i></a>
                                            <a href="#" data-target="list-view" data-toggle="tooltip" title="List View"><i
                                                        class="fa fa-list"></i></a>
                                        </div>
                                        <div class="product-amount">
                                            <p>Showing 1–5 of 8 results</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-5 col-md-6 order-1 order-md-2">
                                    <div class="top-bar-right">
                                        <div class="product-short">
                                            <p>Sort By : </p>
                                            <select class="nice-select" name="sortby">
                                                <option value="trending">Relevance</option>
                                                <option value="sales">Name (A - Z)</option>
                                                <option value="sales">Name (Z - A)</option>
                                                <option value="rating">Price (Low &gt; High)</option>
                                                <option value="date">Rating (Lowest)</option>
                                                <option value="price-asc">Model (A - Z)</option>
                                                <option value="price-asc">Model (Z - A)</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- shop product top wrap start -->

                        <!-- product item list wrapper start -->
                        <div class="shop-product-wrap grid-view row mbn-40">
                            <!-- product single item start -->
                            <div class="col-md-4 col-sm-6">
                                <!-- product grid start -->
                                <div class="product-item">
                                    <figure class="product-thumb">
                                        <a href="product-details.ftl">
                                            <img class="pri-img" src="${path}/static/assets/img/product/product-1.jpg"
                                                 alt="product">
                                            <img class="sec-img" src="${path}/static/assets/img/product/product-3.jpg"
                                                 alt="product">
                                        </a>
                                        <div class="product-badge">
                                            <div class="product-label new">
                                                <span>new</span>
                                            </div>
                                            <div class="product-label discount">
                                                <span>10%</span>
                                            </div>
                                        </div>
                                        <div class="button-group">
                                            <a href="#" data-toggle="tooltip" data-placement="left"
                                               title="Add to wishlist"><i class="lnr lnr-heart"></i></a>
                                            <a href="#" data-toggle="modal" data-target="#quick_view"><span
                                                        data-toggle="tooltip" data-placement="left"
                                                        title="Quick View"><i class="lnr lnr-magnifier"></i></span></a>
                                            <a href="#" data-toggle="tooltip" data-placement="left" title="Add to Cart"><i
                                                        class="lnr lnr-cart"></i></a>
                                        </div>
                                    </figure>
                                    <div class="product-caption">
                                        <p class="product-name">
                                            <a href="product-details.ftl">Flowers daisy pink stick</a>
                                        </p>
                                        <div class="price-box">
                                            <span class="price-regular">$40.00</span>
                                            <span class="price-old"><del>$50.00</del></span>
                                        </div>
                                    </div>
                                </div>
                                <!-- product grid end -->

                                <!-- product list item end -->
                                <div class="product-list-item">
                                    <figure class="product-thumb">
                                        <a href="product-details.ftl">
                                            <img class="pri-img" src="${path}/static/assets/img/product/product-1.jpg"
                                                 alt="product">
                                            <img class="sec-img" src="${path}/static/assets/img/product/product-3.jpg"
                                                 alt="product">
                                        </a>
                                        <div class="product-badge">
                                            <div class="product-label new">
                                                <span>new</span>
                                            </div>
                                            <div class="product-label discount">
                                                <span>10%</span>
                                            </div>
                                        </div>
                                    </figure>
                                    <div class="product-content-list">
                                        <h5 class="product-name"><a href="product-details.ftl">Flowers daisy pink
                                                stick</a></h5>
                                        <div class="price-box">
                                            <span class="price-regular">$50.00</span>
                                            <span class="price-old"><del>$60.00</del></span>
                                        </div>
                                        <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Unde perspiciatis
                                            quod numquam, sit fugiat, deserunt ipsa mollitia sunt quam corporis ullam
                                            rem, accusantium adipisci officia eaque.
                                        </p>
                                        <div class="button-group-list">
                                            <a class="btn-big" href="#" data-toggle="tooltip" title="Add to Cart"><i
                                                        class="lnr lnr-cart"></i>Add to Cart</a>
                                            <a href="#" data-toggle="modal" data-target="#quick_view"><span
                                                        data-toggle="tooltip" title="Quick View"><i
                                                            class="lnr lnr-magnifier"></i></span></a>
                                            <a href="#" data-toggle="tooltip" title="Add to wishlist"><i
                                                        class="lnr lnr-heart"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <!-- product list item end -->
                            </div>
                            <!-- product single item start -->

                            <!-- product single item start -->
                            <div class="col-md-4 col-sm-6">
                                <!-- product grid start -->
                                <div class="product-item">
                                    <figure class="product-thumb">
                                        <a href="product-details.ftl">
                                            <img class="pri-img" src="${path}/static/assets/img/product/product-2.jpg"
                                                 alt="product">
                                            <img class="sec-img" src="${path}/static/assets/img/product/product-4.jpg"
                                                 alt="product">
                                        </a>
                                        <div class="product-badge">
                                            <div class="product-label new">
                                                <span>new</span>
                                            </div>
                                            <div class="product-label discount">
                                                <span>5%</span>
                                            </div>
                                        </div>
                                        <div class="button-group">
                                            <a href="#" data-toggle="tooltip" data-placement="left"
                                               title="Add to wishlist"><i class="lnr lnr-heart"></i></a>
                                            <a href="#" data-toggle="modal" data-target="#quick_view"><span
                                                        data-toggle="tooltip" data-placement="left"
                                                        title="Quick View"><i class="lnr lnr-magnifier"></i></span></a>
                                            <a href="#" data-toggle="tooltip" data-placement="left" title="Add to Cart"><i
                                                        class="lnr lnr-cart"></i></a>
                                        </div>
                                    </figure>
                                    <div class="product-caption">
                                        <p class="product-name">
                                            <a href="product-details.ftl">Jasmine flowers white</a>
                                        </p>
                                        <div class="price-box">
                                            <span class="price-regular">$20.00</span>
                                            <span class="price-old"><del>$70.00</del></span>
                                        </div>
                                    </div>
                                </div>
                                <!-- product grid end -->

                                <!-- product list item end -->
                                <div class="product-list-item">
                                    <figure class="product-thumb">
                                        <a href="product-details.ftl">
                                            <img class="pri-img" src="${path}/static/assets/img/product/product-2.jpg"
                                                 alt="product">
                                            <img class="sec-img" src="${path}/static/assets/img/product/product-4.jpg"
                                                 alt="product">
                                        </a>
                                        <div class="product-badge">
                                            <div class="product-label new">
                                                <span>new</span>
                                            </div>
                                            <div class="product-label discount">
                                                <span>10%</span>
                                            </div>
                                        </div>
                                    </figure>
                                    <div class="product-content-list">
                                        <h5 class="product-name"><a href="product-details.ftl">Jasmine flowers white</a>
                                        </h5>
                                        <div class="price-box">
                                            <span class="price-regular">$60.00</span>
                                            <span class="price-old"><del>$80.00</del></span>
                                        </div>
                                        <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Unde perspiciatis
                                            quod numquam, sit fugiat, deserunt ipsa mollitia sunt quam corporis ullam
                                            rem, accusantium adipisci officia eaque.
                                        </p>
                                        <div class="button-group-list">
                                            <a class="btn-big" href="#" data-toggle="tooltip" title="Add to Cart"><i
                                                        class="lnr lnr-cart"></i>Add to Cart</a>
                                            <a href="#" data-toggle="modal" data-target="#quick_view"><span
                                                        data-toggle="tooltip" title="Quick View"><i
                                                            class="lnr lnr-magnifier"></i></span></a>
                                            <a href="#" data-toggle="tooltip" title="Add to wishlist"><i
                                                        class="lnr lnr-heart"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <!-- product list item end -->
                            </div>
                            <!-- product single item start -->

                            <!-- product single item start -->
                            <div class="col-md-4 col-sm-6">
                                <!-- product grid start -->
                                <div class="product-item">
                                    <figure class="product-thumb">
                                        <a href="product-details.ftl">
                                            <img class="pri-img" src="${path}/static/assets/img/product/product-5.jpg"
                                                 alt="product">
                                            <img class="sec-img" src="${path}/static/assets/img/product/product-6.jpg"
                                                 alt="product">
                                        </a>
                                        <div class="product-badge">
                                            <div class="product-label new">
                                                <span>new</span>
                                            </div>
                                        </div>
                                        <div class="button-group">
                                            <a href="#" data-toggle="tooltip" data-placement="left"
                                               title="Add to wishlist"><i class="lnr lnr-heart"></i></a>
                                            <a href="#" data-toggle="modal" data-target="#quick_view"><span
                                                        data-toggle="tooltip" data-placement="left"
                                                        title="Quick View"><i class="lnr lnr-magnifier"></i></span></a>
                                            <a href="#" data-toggle="tooltip" data-placement="left" title="Add to Cart"><i
                                                        class="lnr lnr-cart"></i></a>
                                        </div>
                                    </figure>
                                    <div class="product-caption">
                                        <p class="product-name">
                                            <a href="product-details.ftl">Blossom bouquet flower</a>
                                        </p>
                                        <div class="price-box">
                                            <span class="price-regular">$35.00</span>
                                            <span class="price-old"><del>$60.00</del></span>
                                        </div>
                                    </div>
                                </div>
                                <!-- product grid end -->

                                <!-- product list item end -->
                                <div class="product-list-item">
                                    <figure class="product-thumb">
                                        <a href="product-details.ftl">
                                            <img class="pri-img" src="${path}/static/assets/img/product/product-5.jpg"
                                                 alt="product">
                                            <img class="sec-img" src="${path}/static/assets/img/product/product-6.jpg"
                                                 alt="product">
                                        </a>
                                        <div class="product-badge">
                                            <div class="product-label new">
                                                <span>new</span>
                                            </div>
                                            <div class="product-label discount">
                                                <span>10%</span>
                                            </div>
                                        </div>
                                    </figure>
                                    <div class="product-content-list">
                                        <h5 class="product-name"><a href="product-details.ftl">Blossom bouquet
                                                flower</a></h5>
                                        <div class="price-box">
                                            <span class="price-regular">$45.00</span>
                                            <span class="price-old"><del>$55.00</del></span>
                                        </div>
                                        <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Unde perspiciatis
                                            quod numquam, sit fugiat, deserunt ipsa mollitia sunt quam corporis ullam
                                            rem, accusantium adipisci officia eaque.
                                        </p>
                                        <div class="button-group-list">
                                            <a class="btn-big" href="#" data-toggle="tooltip" data-placement="top"
                                               title="Add to Cart"><i class="lnr lnr-cart"></i>Add to Cart</a>
                                            <a href="#" data-toggle="modal" data-target="#quick_view"><span
                                                        data-toggle="tooltip" data-placement="top" title="Quick View"><i
                                                            class="lnr lnr-magnifier"></i></span></a>
                                            <a href="#" data-toggle="tooltip" title="Add to wishlist"><i
                                                        class="lnr lnr-heart"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <!-- product list item end -->
                            </div>
                            <!-- product single item start -->

                            <!-- product single item start -->
                            <div class="col-md-4 col-sm-6">
                                <!-- product grid start -->
                                <div class="product-item">
                                    <figure class="product-thumb">
                                        <a href="product-details.ftl">
                                            <img class="pri-img" src="${path}/static/assets/img/product/product-7.jpg"
                                                 alt="product">
                                            <img class="sec-img" src="${path}/static/assets/img/product/product-9.jpg"
                                                 alt="product">
                                        </a>
                                        <div class="product-badge">
                                            <div class="product-label new">
                                                <span>new</span>
                                            </div>
                                            <div class="product-label discount">
                                                <span>12%</span>
                                            </div>
                                        </div>
                                        <div class="button-group">
                                            <a href="#" data-toggle="tooltip" data-placement="left"
                                               title="Add to wishlist"><i class="lnr lnr-heart"></i></a>
                                            <a href="#" data-toggle="modal" data-target="#quick_view"><span
                                                        data-toggle="tooltip" data-placement="left"
                                                        title="Quick View"><i class="lnr lnr-magnifier"></i></span></a>
                                            <a href="#" data-toggle="tooltip" data-placement="left" title="Add to Cart"><i
                                                        class="lnr lnr-cart"></i></a>
                                        </div>
                                    </figure>
                                    <div class="product-caption">
                                        <p class="product-name">
                                            <a href="product-details.ftl">Hyacinth white stick</a>
                                        </p>
                                        <div class="price-box">
                                            <span class="price-regular">$35.00</span>
                                            <span class="price-old"><del>$45.00</del></span>
                                        </div>
                                    </div>
                                </div>
                                <!-- product grid end -->

                                <!-- product list item end -->
                                <div class="product-list-item">
                                    <figure class="product-thumb">
                                        <a href="product-details.ftl">
                                            <img class="pri-img" src="${path}/static/assets/img/product/product-7.jpg"
                                                 alt="product">
                                            <img class="sec-img" src="${path}/static/assets/img/product/product-9.jpg"
                                                 alt="product">
                                        </a>
                                        <div class="product-badge">
                                            <div class="product-label new">
                                                <span>new</span>
                                            </div>
                                            <div class="product-label discount">
                                                <span>10%</span>
                                            </div>
                                        </div>
                                    </figure>
                                    <div class="product-content-list">
                                        <h5 class="product-name"><a href="product-details.ftl">Jasmine flowers white</a>
                                        </h5>
                                        <div class="price-box">
                                            <span class="price-regular">$25.00</span>
                                            <span class="price-old"><del>$35.00</del></span>
                                        </div>
                                        <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Unde perspiciatis
                                            quod numquam, sit fugiat, deserunt ipsa mollitia sunt quam corporis ullam
                                            rem, accusantium adipisci officia eaque.
                                        </p>
                                        <div class="button-group-list">
                                            <a class="btn-big" href="#" data-toggle="tooltip" title="Add to Cart"><i
                                                        class="lnr lnr-cart"></i>Add to Cart</a>
                                            <a href="#" data-toggle="modal" data-target="#quick_view"><span
                                                        data-toggle="tooltip" title="Quick View"><i
                                                            class="lnr lnr-magnifier"></i></span></a>
                                            <a href="#" data-toggle="tooltip" title="Add to wishlist"><i
                                                        class="lnr lnr-heart"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <!-- product list item end -->
                            </div>
                            <!-- product single item start -->

                            <!-- product single item start -->
                            <div class="col-md-4 col-sm-6">
                                <!-- product grid start -->
                                <div class="product-item">
                                    <figure class="product-thumb">
                                        <a href="product-details.ftl">
                                            <img class="pri-img" src="${path}/static/assets/img/product/product-10.jpg"
                                                 alt="product">
                                            <img class="sec-img" src="${path}/static/assets/img/product/product-12.jpg"
                                                 alt="product">
                                        </a>
                                        <div class="product-badge">
                                            <div class="product-label new">
                                                <span>new</span>
                                            </div>
                                        </div>
                                        <div class="button-group">
                                            <a href="#" data-toggle="tooltip" data-placement="left"
                                               title="Add to wishlist"><i class="lnr lnr-heart"></i></a>
                                            <a href="#" data-toggle="modal" data-target="#quick_view"><span
                                                        data-toggle="tooltip" data-placement="left"
                                                        title="Quick View"><i class="lnr lnr-magnifier"></i></span></a>
                                            <a href="#" data-toggle="tooltip" data-placement="left" title="Add to Cart"><i
                                                        class="lnr lnr-cart"></i></a>
                                        </div>
                                    </figure>
                                    <div class="product-caption">
                                        <p class="product-name">
                                            <a href="product-details.ftl">Orchid flower red stick</a>
                                        </p>
                                        <div class="price-box">
                                            <span class="price-regular">$45.00</span>
                                            <span class="price-old"><del>$65.00</del></span>
                                        </div>
                                    </div>
                                </div>
                                <!-- product grid end -->

                                <!-- product list item end -->
                                <div class="product-list-item">
                                    <figure class="product-thumb">
                                        <a href="product-details.ftl">
                                            <img class="pri-img" src="${path}/static/assets/img/product/product-10.jpg"
                                                 alt="product">
                                            <img class="sec-img" src="${path}/static/assets/img/product/product-12.jpg"
                                                 alt="product">
                                        </a>
                                        <div class="product-badge">
                                            <div class="product-label new">
                                                <span>new</span>
                                            </div>
                                            <div class="product-label discount">
                                                <span>10%</span>
                                            </div>
                                        </div>
                                    </figure>
                                    <div class="product-content-list">
                                        <h5 class="product-name"><a href="product-details.ftl">Orchid flower red
                                                stick</a></h5>
                                        <div class="price-box">
                                            <span class="price-regular">$600.00</span>
                                            <span class="price-old"><del>$70.00</del></span>
                                        </div>
                                        <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Unde perspiciatis
                                            quod numquam, sit fugiat, deserunt ipsa mollitia sunt quam corporis ullam
                                            rem, accusantium adipisci officia eaque.
                                        </p>
                                        <div class="button-group-list">
                                            <a class="btn-big" href="#" data-toggle="tooltip" data-placement="top"
                                               title="Add to Cart"><i class="lnr lnr-cart"></i>Add to Cart</a>
                                            <a href="#" data-toggle="modal" data-target="#quick_view"><span
                                                        data-toggle="tooltip" data-placement="top" title="Quick View"><i
                                                            class="lnr lnr-magnifier"></i></span></a>
                                            <a href="#" data-toggle="tooltip" title="Add to wishlist"><i
                                                        class="lnr lnr-heart"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <!-- product list item end -->
                            </div>
                            <!-- product single item start -->

                            <!-- product single item start -->
                            <div class="col-md-4 col-sm-6">
                                <!-- product grid start -->
                                <div class="product-item">
                                    <figure class="product-thumb">
                                        <a href="product-details.ftl">
                                            <img class="pri-img" src="${path}/static/assets/img/product/product-3.jpg"
                                                 alt="product">
                                            <img class="sec-img" src="${path}/static/assets/img/product/product-1.jpg"
                                                 alt="product">
                                        </a>
                                        <div class="product-badge">
                                            <div class="product-label new">
                                                <span>new</span>
                                            </div>
                                            <div class="product-label discount">
                                                <span>4%</span>
                                            </div>
                                        </div>
                                        <div class="button-group">
                                            <a href="#" data-toggle="tooltip" data-placement="left"
                                               title="Add to wishlist"><i class="lnr lnr-heart"></i></a>
                                            <a href="#" data-toggle="modal" data-target="#quick_view"><span
                                                        data-toggle="tooltip" data-placement="left"
                                                        title="Quick View"><i class="lnr lnr-magnifier"></i></span></a>
                                            <a href="#" data-toggle="tooltip" data-placement="left" title="Add to Cart"><i
                                                        class="lnr lnr-cart"></i></a>
                                        </div>
                                    </figure>
                                    <div class="product-caption">
                                        <p class="product-name">
                                            <a href="product-details.ftl">Flowers daisy pink stick</a>
                                        </p>
                                        <div class="price-box">
                                            <span class="price-regular">$40.00</span>
                                            <span class="price-old"><del>$50.00</del></span>
                                        </div>
                                    </div>
                                </div>
                                <!-- product grid end -->

                                <!-- product list item end -->
                                <div class="product-list-item">
                                    <figure class="product-thumb">
                                        <a href="product-details.ftl">
                                            <img class="pri-img" src="${path}/static/assets/img/product/product-3.jpg"
                                                 alt="product">
                                            <img class="sec-img" src="${path}/static/assets/img/product/product-1.jpg"
                                                 alt="product">
                                        </a>
                                        <div class="product-badge">
                                            <div class="product-label new">
                                                <span>new</span>
                                            </div>
                                            <div class="product-label discount">
                                                <span>10%</span>
                                            </div>
                                        </div>
                                    </figure>
                                    <div class="product-content-list">
                                        <h5 class="product-name"><a href="product-details.ftl">Jasmine flowers white</a>
                                        </h5>
                                        <div class="price-box">
                                            <span class="price-regular">$40.00</span>
                                            <span class="price-old"><del>$50.00</del></span>
                                        </div>
                                        <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Unde perspiciatis
                                            quod numquam, sit fugiat, deserunt ipsa mollitia sunt quam corporis ullam
                                            rem, accusantium adipisci officia eaque.
                                        </p>
                                        <div class="button-group-list">
                                            <a class="btn-big" href="#" data-toggle="tooltip" title="Add to Cart"><i
                                                        class="lnr lnr-cart"></i>Add to Cart</a>
                                            <a href="#" data-toggle="modal" data-target="#quick_view"><span
                                                        data-toggle="tooltip" title="Quick View"><i
                                                            class="lnr lnr-magnifier"></i></span></a>
                                            <a href="#" data-toggle="tooltip" title="Add to wishlist"><i
                                                        class="lnr lnr-heart"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <!-- product list item end -->
                            </div>
                            <!-- product single item start -->

                            <!-- product single item start -->
                            <div class="col-md-4 col-sm-6">
                                <!-- product grid start -->
                                <div class="product-item">
                                    <figure class="product-thumb">
                                        <a href="product-details.ftl">
                                            <img class="pri-img" src="${path}/static/assets/img/product/product-5.jpg"
                                                 alt="product">
                                            <img class="sec-img" src="${path}/static/assets/img/product/product-3.jpg"
                                                 alt="product">
                                        </a>
                                        <div class="product-badge">
                                            <div class="product-label new">
                                                <span>new</span>
                                            </div>
                                            <div class="product-label discount">
                                                <span>15%</span>
                                            </div>
                                        </div>
                                        <div class="button-group">
                                            <a href="#" data-toggle="tooltip" data-placement="left"
                                               title="Add to wishlist"><i class="lnr lnr-heart"></i></a>
                                            <a href="#" data-toggle="modal" data-target="#quick_view"><span
                                                        data-toggle="tooltip" data-placement="left"
                                                        title="Quick View"><i class="lnr lnr-magnifier"></i></span></a>
                                            <a href="#" data-toggle="tooltip" data-placement="left" title="Add to Cart"><i
                                                        class="lnr lnr-cart"></i></a>
                                        </div>
                                    </figure>
                                    <div class="product-caption">
                                        <p class="product-name">
                                            <a href="product-details.ftl">Rose bouquet white</a>
                                        </p>
                                        <div class="price-box">
                                            <span class="price-regular">$20.00</span>
                                            <span class="price-old"><del>$30.00</del></span>
                                        </div>
                                    </div>
                                </div>
                                <!-- product grid end -->

                                <!-- product list item end -->
                                <div class="product-list-item">
                                    <figure class="product-thumb">
                                        <a href="product-details.ftl">
                                            <img class="pri-img" src="${path}/static/assets/img/product/product-5.jpg"
                                                 alt="product">
                                            <img class="sec-img" src="${path}/static/assets/img/product/product-3.jpg"
                                                 alt="product">
                                        </a>
                                        <div class="product-badge">
                                            <div class="product-label new">
                                                <span>new</span>
                                            </div>
                                            <div class="product-label discount">
                                                <span>10%</span>
                                            </div>
                                        </div>
                                    </figure>
                                    <div class="product-content-list">
                                        <h5 class="product-name"><a href="product-details.ftl">Rose bouquet white</a>
                                        </h5>
                                        <div class="price-box">
                                            <span class="price-regular">$70.00</span>
                                            <span class="price-old"><del>$90.00</del></span>
                                        </div>
                                        <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Unde perspiciatis
                                            quod numquam, sit fugiat, deserunt ipsa mollitia sunt quam corporis ullam
                                            rem, accusantium adipisci officia eaque.
                                        </p>
                                        <div class="button-group-list">
                                            <a class="btn-big" href="#" data-toggle="tooltip" title="Add to Cart"><i
                                                        class="lnr lnr-cart"></i>Add to Cart</a>
                                            <a href="#" data-toggle="modal" data-target="#quick_view"><span
                                                        data-toggle="tooltip" title="Quick View"><i
                                                            class="lnr lnr-magnifier"></i></span></a>
                                            <a href="#" data-toggle="tooltip" title="Add to wishlist"><i
                                                        class="lnr lnr-heart"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <!-- product list item end -->
                            </div>
                            <!-- product single item start -->

                            <!-- product single item start -->
                            <div class="col-md-4 col-sm-6">
                                <!-- product grid start -->
                                <div class="product-item">
                                    <figure class="product-thumb">
                                        <a href="product-details.ftl">
                                            <img class="pri-img" src="${path}/static/assets/img/product/product-7.jpg"
                                                 alt="product">
                                            <img class="sec-img" src="${path}/static/assets/img/product/product-5.jpg"
                                                 alt="product">
                                        </a>
                                        <div class="product-badge">
                                            <div class="product-label discount">
                                                <span>12%</span>
                                            </div>
                                        </div>
                                        <div class="button-group">
                                            <a href="#" data-toggle="tooltip" data-placement="left"
                                               title="Add to wishlist"><i class="lnr lnr-heart"></i></a>
                                            <a href="#" data-toggle="modal" data-target="#quick_view"><span
                                                        data-toggle="tooltip" data-placement="left"
                                                        title="Quick View"><i class="lnr lnr-magnifier"></i></span></a>
                                            <a href="#" data-toggle="tooltip" data-placement="left" title="Add to Cart"><i
                                                        class="lnr lnr-cart"></i></a>
                                        </div>
                                    </figure>
                                    <div class="product-caption">
                                        <p class="product-name">
                                            <a href="product-details.ftl">Blossom bouquet flower</a>
                                        </p>
                                        <div class="price-box">
                                            <span class="price-regular">$25.00</span>
                                            <span class="price-old"><del>$35.00</del></span>
                                        </div>
                                    </div>
                                </div>
                                <!-- product grid end -->

                                <!-- product list item end -->
                                <div class="product-list-item">
                                    <figure class="product-thumb">
                                        <a href="product-details.ftl">
                                            <img class="pri-img" src="${path}/static/assets/img/product/product-7.jpg"
                                                 alt="product">
                                            <img class="sec-img" src="${path}/static/assets/img/product/product-5.jpg"
                                                 alt="product">
                                        </a>
                                        <div class="product-badge">
                                            <div class="product-label new">
                                                <span>new</span>
                                            </div>
                                            <div class="product-label discount">
                                                <span>10%</span>
                                            </div>
                                        </div>
                                    </figure>
                                    <div class="product-content-list">
                                        <h5 class="product-name"><a href="product-details.ftl">Blossom bouquet
                                                flower</a></h5>
                                        <div class="price-box">
                                            <span class="price-regular">$40.00</span>
                                            <span class="price-old"><del>$50.00</del></span>
                                        </div>
                                        <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Unde perspiciatis
                                            quod numquam, sit fugiat, deserunt ipsa mollitia sunt quam corporis ullam
                                            rem, accusantium adipisci officia eaque.
                                        </p>
                                        <div class="button-group-list">
                                            <a class="btn-big" href="#" data-toggle="tooltip" title="Add to Cart"><i
                                                        class="lnr lnr-cart"></i>Add to Cart</a>
                                            <a href="#" data-toggle="modal" data-target="#quick_view"><span
                                                        data-toggle="tooltip" title="Quick View"><i
                                                            class="lnr lnr-magnifier"></i></span></a>
                                            <a href="#" data-toggle="tooltip" title="Add to wishlist"><i
                                                        class="lnr lnr-heart"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <!-- product list item end -->
                            </div>
                            <!-- product single item start -->

                            <!-- product single item start -->
                            <div class="col-md-4 col-sm-6">
                                <!-- product grid start -->
                                <div class="product-item">
                                    <figure class="product-thumb">
                                        <a href="product-details.ftl">
                                            <img class="pri-img" src="${path}/static/assets/img/product/product-9.jpg"
                                                 alt="product">
                                            <img class="sec-img" src="${path}/static/assets/img/product/product-7.jpg"
                                                 alt="product">
                                        </a>
                                        <div class="product-badge">
                                            <div class="product-label new">
                                                <span>new</span>
                                            </div>
                                            <div class="product-label discount">
                                                <span>50%</span>
                                            </div>
                                        </div>
                                        <div class="button-group">
                                            <a href="#" data-toggle="tooltip" data-placement="left"
                                               title="Add to wishlist"><i class="lnr lnr-heart"></i></a>
                                            <a href="#" data-toggle="modal" data-target="#quick_view"><span
                                                        data-toggle="tooltip" data-placement="left"
                                                        title="Quick View"><i class="lnr lnr-magnifier"></i></span></a>
                                            <a href="#" data-toggle="tooltip" data-placement="left" title="Add to Cart"><i
                                                        class="lnr lnr-cart"></i></a>
                                        </div>
                                    </figure>
                                    <div class="product-caption">
                                        <p class="product-name">
                                            <a href="product-details.ftl">Flowers daisy pink stick</a>
                                        </p>
                                        <div class="price-box">
                                            <span class="price-regular">$10.00</span>
                                            <span class="price-old"><del>$20.00</del></span>
                                        </div>
                                    </div>
                                </div>
                                <!-- product grid end -->

                                <!-- product list item end -->
                                <div class="product-list-item">
                                    <figure class="product-thumb">
                                        <a href="product-details.ftl">
                                            <img class="pri-img" src="${path}/static/assets/img/product/product-9.jpg"
                                                 alt="product">
                                            <img class="sec-img" src="${path}/static/assets/img/product/product-7.jpg"
                                                 alt="product">
                                        </a>
                                        <div class="product-badge">
                                            <div class="product-label new">
                                                <span>new</span>
                                            </div>
                                            <div class="product-label discount">
                                                <span>10%</span>
                                            </div>
                                        </div>
                                    </figure>
                                    <div class="product-content-list">
                                        <h5 class="product-name"><a href="product-details.ftl">Flowers daisy pink
                                                stick</a></h5>
                                        <div class="price-box">
                                            <span class="price-regular">$30.00</span>
                                            <span class="price-old"><del>$40.00</del></span>
                                        </div>
                                        <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Unde perspiciatis
                                            quod numquam, sit fugiat, deserunt ipsa mollitia sunt quam corporis ullam
                                            rem, accusantium adipisci officia eaque.
                                        </p>
                                        <div class="button-group-list">
                                            <a class="btn-big" href="#" data-toggle="tooltip" data-placement="top"
                                               title="Add to Cart"><i class="lnr lnr-cart"></i>Add to Cart</a>
                                            <a href="#" data-toggle="modal" data-target="#quick_view"><span
                                                        data-toggle="tooltip" data-placement="top" title="Quick View"><i
                                                            class="lnr lnr-magnifier"></i></span></a>
                                            <a href="#" data-toggle="tooltip" data-placement="top"
                                               title="Add to wishlist"><i class="lnr lnr-heart"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <!-- product list item end -->
                            </div>
                            <!-- product single item start -->

                            <!-- product single item start -->
                            <div class="col-md-4 col-sm-6">
                                <!-- product grid start -->
                                <div class="product-item">
                                    <figure class="product-thumb">
                                        <a href="product-details.ftl">
                                            <img class="pri-img" src="${path}/static/assets/img/product/product-11.jpg"
                                                 alt="product">
                                            <img class="sec-img" src="${path}/static/assets/img/product/product-12.jpg"
                                                 alt="product">
                                        </a>
                                        <div class="product-badge">
                                            <div class="product-label new">
                                                <span>new</span>
                                            </div>
                                            <div class="product-label discount">
                                                <span>12%</span>
                                            </div>
                                        </div>
                                        <div class="button-group">
                                            <a href="#" data-toggle="tooltip" data-placement="left"
                                               title="Add to wishlist"><i class="lnr lnr-heart"></i></a>
                                            <a href="#" data-toggle="modal" data-target="#quick_view"><span
                                                        data-toggle="tooltip" data-placement="left"
                                                        title="Quick View"><i class="lnr lnr-magnifier"></i></span></a>
                                            <a href="#" data-toggle="tooltip" data-placement="left" title="Add to Cart"><i
                                                        class="lnr lnr-cart"></i></a>
                                        </div>
                                    </figure>
                                    <div class="product-caption">
                                        <p class="product-name">
                                            <a href="product-details.ftl">Hyacinth white stick</a>
                                        </p>
                                        <div class="price-box">
                                            <span class="price-regular">$90.00</span>
                                        </div>
                                    </div>
                                </div>
                                <!-- product grid end -->

                                <!-- product list item end -->
                                <div class="product-list-item">
                                    <figure class="product-thumb">
                                        <a href="product-details.ftl">
                                            <img class="pri-img" src="${path}/static/assets/img/product/product-11.jpg"
                                                 alt="product">
                                            <img class="sec-img" src="${path}/static/assets/img/product/product-12.jpg"
                                                 alt="product">
                                        </a>
                                        <div class="product-badge">
                                            <div class="product-label new">
                                                <span>new</span>
                                            </div>
                                            <div class="product-label discount">
                                                <span>10%</span>
                                            </div>
                                        </div>
                                    </figure>
                                    <div class="product-content-list">
                                        <h5 class="product-name"><a href="product-details.ftl">Hyacinth white stick</a>
                                        </h5>
                                        <div class="price-box">
                                            <span class="price-regular">$10.00</span>
                                            <span class="price-old"><del>$20.00</del></span>
                                        </div>
                                        <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Unde perspiciatis
                                            quod numquam, sit fugiat, deserunt ipsa mollitia sunt quam corporis ullam
                                            rem, accusantium adipisci officia eaque.
                                        </p>
                                        <div class="button-group-list">
                                            <a class="btn-big" href="#" data-toggle="tooltip" title="Add to Cart"><i
                                                        class="lnr lnr-cart"></i>Add to Cart</a>
                                            <a href="#" data-toggle="modal" data-target="#quick_view"><span
                                                        data-toggle="tooltip" title="Quick View"><i
                                                            class="lnr lnr-magnifier"></i></span></a>
                                            <a href="#" data-toggle="tooltip" title="Add to wishlist"><i
                                                        class="lnr lnr-heart"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <!-- product list item end -->
                            </div>
                            <!-- product single item start -->

                            <!-- product single item start -->
                            <div class="col-md-4 col-sm-6">
                                <!-- product grid start -->
                                <div class="product-item">
                                    <figure class="product-thumb">
                                        <a href="product-details.ftl">
                                            <img class="pri-img" src="${path}/static/assets/img/product/product-8.jpg"
                                                 alt="product">
                                            <img class="sec-img" src="${path}/static/assets/img/product/product-6.jpg"
                                                 alt="product">
                                        </a>
                                        <div class="product-badge">
                                            <div class="product-label new">
                                                <span>new</span>
                                            </div>
                                            <div class="product-label discount">
                                                <span>20%</span>
                                            </div>
                                        </div>
                                        <div class="button-group">
                                            <a href="#" data-toggle="tooltip" data-placement="left"
                                               title="Add to wishlist"><i class="lnr lnr-heart"></i></a>
                                            <a href="#" data-toggle="modal" data-target="#quick_view"><span
                                                        data-toggle="tooltip" data-placement="left"
                                                        title="Quick View"><i class="lnr lnr-magnifier"></i></span></a>
                                            <a href="#" data-toggle="tooltip" data-placement="left" title="Add to Cart"><i
                                                        class="lnr lnr-cart"></i></a>
                                        </div>
                                    </figure>
                                    <div class="product-caption">
                                        <p class="product-name">
                                            <a href="product-details.ftl">Flowers daisy pink stick</a>
                                        </p>
                                        <div class="price-box">
                                            <span class="price-regular">$30.00</span>
                                            <span class="price-old"><del>$40.00</del></span>
                                        </div>
                                    </div>
                                </div>
                                <!-- product grid end -->

                                <!-- product list item end -->
                                <div class="product-list-item">
                                    <figure class="product-thumb">
                                        <a href="product-details.ftl">
                                            <img class="pri-img" src="${path}/static/assets/img/product/product-8.jpg"
                                                 alt="product">
                                            <img class="sec-img" src="${path}/static/assets/img/product/product-6.jpg"
                                                 alt="product">
                                        </a>
                                        <div class="product-badge">
                                            <div class="product-label new">
                                                <span>new</span>
                                            </div>
                                            <div class="product-label discount">
                                                <span>10%</span>
                                            </div>
                                        </div>
                                    </figure>
                                    <div class="product-content-list">
                                        <h5 class="product-name"><a href="product-details.ftl">Flowers daisy pink
                                                stick</a></h5>
                                        <div class="price-box">
                                            <span class="price-regular">$80.00</span>
                                            <span class="price-old"><del>$90.00</del></span>
                                        </div>
                                        <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Unde perspiciatis
                                            quod numquam, sit fugiat, deserunt ipsa mollitia sunt quam corporis ullam
                                            rem, accusantium adipisci officia eaque.
                                        </p>
                                        <div class="button-group-list">
                                            <a class="btn-big" href="#" data-toggle="tooltip" title="Add to Cart"><i
                                                        class="lnr lnr-cart"></i>Add to Cart</a>
                                            <a href="#" data-toggle="modal" data-target="#quick_view"><span
                                                        data-toggle="tooltip" title="Quick View"><i
                                                            class="lnr lnr-magnifier"></i></span></a>
                                            <a href="#" data-toggle="tooltip" title="Add to wishlist"><i
                                                        class="lnr lnr-heart"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <!-- product list item end -->
                            </div>
                            <!-- product single item start -->

                            <!-- product single item start -->
                            <div class="col-md-4 col-sm-6">
                                <!-- product grid start -->
                                <div class="product-item">
                                    <figure class="product-thumb">
                                        <a href="product-details.ftl">
                                            <img class="pri-img" src="${path}/static/assets/img/product/product-9.jpg"
                                                 alt="product">
                                            <img class="sec-img" src="${path}/static/assets/img/product/product-8.jpg"
                                                 alt="product">
                                        </a>
                                        <div class="product-badge">
                                            <div class="product-label new">
                                                <span>new</span>
                                            </div>
                                            <div class="product-label discount">
                                                <span>18%</span>
                                            </div>
                                        </div>
                                        <div class="button-group">
                                            <a href="#" data-toggle="tooltip" data-placement="left"
                                               title="Add to wishlist"><i class="lnr lnr-heart"></i></a>
                                            <a href="#" data-toggle="modal" data-target="#quick_view"><span
                                                        data-toggle="tooltip" data-placement="left"
                                                        title="Quick View"><i class="lnr lnr-magnifier"></i></span></a>
                                            <a href="#" data-toggle="tooltip" data-placement="left" title="Add to Cart"><i
                                                        class="lnr lnr-cart"></i></a>
                                        </div>
                                    </figure>
                                    <div class="product-caption">
                                        <p class="product-name">
                                            <a href="product-details.ftl">Blossom bouquet flower</a>
                                        </p>
                                        <div class="price-box">
                                            <span class="price-regular">$52.00</span>
                                            <span class="price-old"><del>$68.00</del></span>
                                        </div>
                                    </div>
                                </div>
                                <!-- product grid end -->

                                <!-- product list item end -->
                                <div class="product-list-item">
                                    <figure class="product-thumb">
                                        <a href="product-details.ftl">
                                            <img class="pri-img" src="${path}/static/assets/img/product/product-9.jpg"
                                                 alt="product">
                                            <img class="sec-img" src="${path}/static/assets/img/product/product-8.jpg"
                                                 alt="product">
                                        </a>
                                        <div class="product-badge">
                                            <div class="product-label new">
                                                <span>new</span>
                                            </div>
                                            <div class="product-label discount">
                                                <span>10%</span>
                                            </div>
                                        </div>
                                    </figure>
                                    <div class="product-content-list">
                                        <h5 class="product-name"><a href="product-details.ftl">Blossom bouquet
                                                flower</a></h5>
                                        <div class="price-box">
                                            <span class="price-regular">$45.00</span>
                                            <span class="price-old"><del>$70.00</del></span>
                                        </div>
                                        <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Unde perspiciatis
                                            quod numquam, sit fugiat, deserunt ipsa mollitia sunt quam corporis ullam
                                            rem, accusantium adipisci officia eaque.
                                        </p>
                                        <div class="button-group-list">
                                            <a class="btn-big" href="#" data-toggle="tooltip" title="Add to Cart"><i
                                                        class="lnr lnr-cart"></i>Add to Cart</a>
                                            <a href="#" data-toggle="modal" data-target="#quick_view"><span
                                                        data-toggle="tooltip" title="Quick View"><i
                                                            class="lnr lnr-magnifier"></i></span></a>
                                            <a href="#" data-toggle="tooltip" title="Add to wishlist"><i
                                                        class="lnr lnr-heart"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <!-- product list item end -->
                            </div>
                            <!-- product single item start -->
                        </div>
                        <!-- product item list wrapper end -->

                        <!-- start pagination area -->
                        <div class="paginatoin-area text-center">
                            <ul class="pagination-box">
                                <li><a class="previous" href="#"><i class="lnr lnr-chevron-left"></i></a></li>
                                <li class="active"><a href="#">1</a></li>
                                <li><a href="#">2</a></li>
                                <li><a href="#">3</a></li>
                                <li><a class="next" href="#"><i class="lnr lnr-chevron-right"></i></a></li>
                            </ul>
                        </div>
                        <!-- end pagination area -->
                    </div>
                </div>
                <!-- shop main wrapper end -->
            </div>
        </div>
    </div>
    <!-- page main wrapper end -->
</main>
<!-- main wrapper end -->

<!-- Start Footer Area Wrapper -->
<footer class="footer-wrapper">

    <!-- footer widget area start -->
    <div class="footer-widget-area">
        <div class="container">
            <div class="footer-widget-inner section-space">
                <div class="row mbn-30">
                    <!-- footer widget item start -->
                    <div class="col-lg-5 col-md-6 col-sm-8">
                        <div class="footer-widget-item mb-30">
                            <div class="footer-widget-title">
                                <h5>My account</h5>
                            </div>
                            <ul class="footer-widget-body accout-widget">
                                <li class="address">
                                    <em><i class="lnr lnr-map-marker"></i></em>
                                    184 Main Rd E, St Albans VIC 3021, Australia
                                </li>
                                <li class="email">
                                    <em><i class="lnr lnr-envelope"></i>Mail us: </em>
                                    <a href="mailto:test@yourdomain.com">yourmail@gmail.com</a>
                                </li>
                                <li class="phone">
                                    <em><i class="lnr lnr-phone-handset"></i> Phones: </em>
                                    <a href="tel:(012)800456789-987">(012) 800 456 789-987</a>
                                </li>
                            </ul>
                            <div class="payment-method">
                                <img src="${path}/static/assets/img/payment-pic.png" alt="payment method">
                            </div>
                        </div>
                    </div>
                    <!-- footer widget item end -->

                    <!-- footer widget item start -->
                    <div class="col-lg-2 col-md-6 col-sm-4">
                        <div class="footer-widget-item mb-30">
                            <div class="footer-widget-title">
                                <h5>categories</h5>
                            </div>
                            <ul class="footer-widget-body">
                                <li><a href="#">Ecommerce</a></li>
                                <li><a href="#">shopify</a></li>
                                <li><a href="#">Prestashop</a></li>
                                <li><a href="#">Opencart</a></li>
                                <li><a href="#">Magento</a></li>
                            </ul>
                        </div>
                    </div>
                    <!-- footer widget item end -->

                    <!-- footer widget item start -->
                    <div class="col-lg-2 col-md-6 col-sm-6">
                        <div class="footer-widget-item mb-30">
                            <div class="footer-widget-title">
                                <h5>information</h5>
                            </div>
                            <ul class="footer-widget-body">
                                <li><a href="#">Home</a></li>
                                <li><a href="#">About Us</a></li>
                                <li><a href="#">Contact Us</a></li>
                                <li><a href="#">Exchanges</a></li>
                                <li><a href="#">Shipping</a></li>
                            </ul>
                        </div>
                    </div>
                    <!-- footer widget item end -->

                    <!-- footer widget item start -->
                    <div class="col-lg-2 offset-lg-1 col-md-6 col-sm-6">
                        <div class="footer-widget-item mb-30">
                            <div class="footer-widget-title">
                                <h5>Quick Links</h5>
                            </div>
                            <ul class="footer-widget-body">
                                <li><a href="#">Store Location</a></li>
                                <li><a href="#">My Account</a></li>
                                <li><a href="#">Orders Tracking</a></li>
                                <li><a href="#">Size Guide</a></li>
                                <li><a href="#">Contact Us</a></li>
                            </ul>
                        </div>
                    </div>
                    <!-- footer widget item end -->
                </div>
            </div>
        </div>
    </div>
    <!-- footer widget area end -->

    <!-- footer bottom area start -->
    <div class="footer-bottom-area">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-md-6 order-2 order-md-1">
                    <div class="copyright-text">
                        <p>Copyright &copy; 2019.Company name All rights reserved.<a target="_blank"
                                                                                     href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a>
                        </p>
                    </div>
                </div>
                <div class="col-md-6 order-1 order-md-2">
                    <div class="footer-social-link">
                        <a href="#"><i class="fa fa-twitter"></i></a>
                        <a href="#"><i class="fa fa-facebook"></i></a>
                        <a href="#"><i class="fa fa-linkedin"></i></a>
                        <a href="#"><i class="fa fa-instagram"></i></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- footer bottom area end -->

</footer>
<!-- End Footer Area Wrapper -->

<!-- Quick view modal start -->
<div class="modal" id="quick_view">
    <div class="modal-dialog modal-lg modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <!-- product details inner end -->
                <div class="product-details-inner">
                    <div class="row">
                        <div class="col-lg-5 col-md-5">
                            <div class="product-large-slider">
                                <div class="pro-large-img">
                                    <img src="${path}/static/assets/img/product/product-details-img1.jpg"
                                         alt="product-details"/>
                                </div>
                                <div class="pro-large-img">
                                    <img src="${path}/static/assets/img/product/product-details-img2.jpg"
                                         alt="product-details"/>
                                </div>
                                <div class="pro-large-img">
                                    <img src="${path}/static/assets/img/product/product-details-img3.jpg"
                                         alt="product-details"/>
                                </div>
                                <div class="pro-large-img">
                                    <img src="${path}/static/assets/img/product/product-details-img4.jpg"
                                         alt="product-details"/>
                                </div>
                            </div>
                            <div class="pro-nav slick-row-10 slick-arrow-style">
                                <div class="pro-nav-thumb">
                                    <img src="${path}/static/assets/img/product/product-details-img1.jpg"
                                         alt="product-details"/>
                                </div>
                                <div class="pro-nav-thumb">
                                    <img src="${path}/static/assets/img/product/product-details-img2.jpg"
                                         alt="product-details"/>
                                </div>
                                <div class="pro-nav-thumb">
                                    <img src="${path}/static/assets/img/product/product-details-img3.jpg"
                                         alt="product-details"/>
                                </div>
                                <div class="pro-nav-thumb">
                                    <img src="${path}/static/assets/img/product/product-details-img4.jpg"
                                         alt="product-details"/>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-7 col-md-7">
                            <div class="product-details-des quick-details">
                                <h3 class="product-name">Orchid flower white stick</h3>
                                <div class="ratings d-flex">
                                    <span><i class="lnr lnr-star"></i></span>
                                    <span><i class="lnr lnr-star"></i></span>
                                    <span><i class="lnr lnr-star"></i></span>
                                    <span><i class="lnr lnr-star"></i></span>
                                    <span><i class="lnr lnr-star"></i></span>
                                    <div class="pro-review">
                                        <span>1 Reviews</span>
                                    </div>
                                </div>
                                <div class="price-box">
                                    <span class="price-regular">$70.00</span>
                                    <span class="price-old"><del>$90.00</del></span>
                                </div>
                                <h5 class="offer-text"><strong>Hurry up</strong>! offer ends in:</h5>
                                <div class="product-countdown" data-countdown="2019/08/25"></div>
                                <div class="availability">
                                    <i class="fa fa-check-circle"></i>
                                    <span>200 in stock</span>
                                </div>
                                <p class="pro-desc">Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam
                                    nonumy
                                    eirmod tempor invidunt ut labore et dolore magna aliquyam erat.</p>
                                <div class="quantity-cart-box d-flex align-items-center">
                                    <h5>qty:</h5>
                                    <div class="quantity">
                                        <div class="pro-qty"><input type="text" value="1"></div>
                                    </div>
                                    <div class="action_link">
                                        <a class="btn btn-cart2" href="#">Add to cart</a>
                                    </div>
                                </div>
                                <div class="useful-links">
                                    <a href="#" data-toggle="tooltip" title="Compare"><i
                                                class="lnr lnr-sync"></i>compare</a>
                                    <a href="#" data-toggle="tooltip" title="Wishlist"><i
                                                class="lnr lnr-heart"></i>wishlist</a>
                                </div>
                                <div class="like-icon">
                                    <a class="facebook" href="#"><i class="fa fa-facebook"></i>like</a>
                                    <a class="twitter" href="#"><i class="fa fa-twitter"></i>tweet</a>
                                    <a class="pinterest" href="#"><i class="fa fa-pinterest"></i>save</a>
                                    <a class="google" href="#"><i class="fa fa-google-plus"></i>share</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div> <!-- product details inner end -->
            </div>
        </div>
    </div>
</div>
<!-- Quick view modal end -->

<!-- offcanvas search form start -->
<div class="offcanvas-search-wrapper">
    <div class="offcanvas-search-inner">
        <div class="offcanvas-close">
            <i class="lnr lnr-cross"></i>
        </div>
        <div class="container">
            <div class="offcanvas-search-box">
                <form class="d-flex bdr-bottom w-100">
                    <input type="text" placeholder="Search entire storage here...">
                    <button class="search-btn"><i class="lnr lnr-magnifier"></i>search</button>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- offcanvas search form end -->

<!-- offcanvas mini cart start -->
<div class="offcanvas-minicart-wrapper">
    <div class="minicart-inner">
        <div class="offcanvas-overlay"></div>
        <div class="minicart-inner-content">
            <div class="minicart-close">
                <i class="lnr lnr-cross"></i>
            </div>
            <div class="minicart-content-box">
                <div class="minicart-item-wrapper">
                    <ul>
                        <li class="minicart-item">
                            <div class="minicart-thumb">
                                <a href="product-details.ftl">
                                    <img src="${path}/static/assets/img/cart/cart-1.jpg" alt="product">
                                </a>
                            </div>
                            <div class="minicart-content">
                                <h3 class="product-name">
                                    <a href="product-details.ftl">Flowers bouquet pink for all flower lovers</a>
                                </h3>
                                <p>
                                    <span class="cart-quantity">1 <strong>&times;</strong></span>
                                    <span class="cart-price">$100.00</span>
                                </p>
                            </div>
                            <button class="minicart-remove"><i class="lnr lnr-cross"></i></button>
                        </li>
                        <li class="minicart-item">
                            <div class="minicart-thumb">
                                <a href="product-details.ftl">
                                    <img src="${path}/static/assets/img/cart/cart-2.jpg" alt="product">
                                </a>
                            </div>
                            <div class="minicart-content">
                                <h3 class="product-name">
                                    <a href="product-details.ftl">Jasmine flowers white for all flower lovers</a>
                                </h3>
                                <p>
                                    <span class="cart-quantity">1 <strong>&times;</strong></span>
                                    <span class="cart-price">$80.00</span>
                                </p>
                            </div>
                            <button class="minicart-remove"><i class="lnr lnr-cross"></i></button>
                        </li>
                    </ul>
                </div>

                <div class="minicart-pricing-box">
                    <ul>
                        <li>
                            <span>sub-total</span>
                            <span><strong>$300.00</strong></span>
                        </li>
                        <li>
                            <span>Eco Tax (-2.00)</span>
                            <span><strong>$10.00</strong></span>
                        </li>
                        <li>
                            <span>VAT (20%)</span>
                            <span><strong>$60.00</strong></span>
                        </li>
                        <li class="total">
                            <span>total</span>
                            <span><strong>$370.00</strong></span>
                        </li>
                    </ul>
                </div>

                <div class="minicart-button">
                    <a href="#"><i class="fa fa-shopping-cart"></i> view cart</a>
                    <a href="#"><i class="fa fa-share"></i> checkout</a>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- offcanvas mini cart end -->

<!-- Scroll to top start -->
<div class="scroll-top not-visible">
    <i class="fa fa-angle-up"></i>
</div>
<!-- Scroll to Top End -->

<!-- All vendor & plugins & active js include here -->
<!--All Vendor Js -->
<script src="${path}/static/assets/js/vendor.js"></script>
<!-- Active Js -->
<script src="${path}/static/assets/js/active.js"></script>
</body>

</html>
