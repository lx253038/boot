<#assign path="${springMacroRequestContext.contextPath}">
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="meta description">
    <title>Home</title>

    <#include "common/cssandjs.ftl">


</head>

<body>

<#include "common/header.ftl">

<!-- main wrapper start -->
<main>
     <#--轮播推荐位-->
    <section class="slider-area">
        <div class="hero-slider-active slick-arrow-style slick-arrow-style_hero slick-dot-style">
            <!-- single slider item start -->
            <#list carouselList as carousel >
                <div class="hero-single-slide ">
                    <div class="hero-slider-item bg-img" data-bg="${carousel.imgurl}">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="hero-slider-content slide-1">
                                        ${carousel.content}
                                        <a href="product" class="btn-hero">shop now</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </#list>

        </div>
    </section>
    <!-- slider area end -->

    <!-- banner statistics start -->
    <section class="banner-statistics section-space">
        <div class="container">
            <div class="row mbn-30">
                <!-- start store item -->
                <div class="col-md-4">
                    <div class="banner-item mb-30">
                        <figure class="banner-thumb">
                            <a href="#">
                                <img src="${path}/static/assets/img/banner/img1-top-floda1.jpg" alt="">
                            </a>
                            <figcaption class="banner-content">
                                <h2 class="text1">Top friday</h2>
                                <h2 class="text2">Yellow Gold</h2>
                                <a class="store-link" href="#">buy it now</a>
                            </figcaption>
                        </figure>
                    </div>
                </div>
                <!-- start store item -->

                <!-- start store item -->
                <div class="col-md-4">
                    <div class="banner-item mb-30">
                        <figure class="banner-thumb">
                            <a href="#">
                                <img src="${path}/static/assets/img/banner/img1-top-floda2.jpg" alt="">
                            </a>
                            <figcaption class="banner-content text-center">
                                <h2 class="text1">Black friday</h2>
                                <h2 class="text2">Orchid stick</h2>
                                <a class="store-link" href="#">buy it now</a>
                            </figcaption>
                        </figure>
                    </div>
                </div>
                <!-- start store item -->

                <!-- start store item -->
                <div class="col-md-4">
                    <div class="banner-item mb-30">
                        <figure class="banner-thumb">
                            <a href="#">
                                <img src="${path}/static/assets/img/banner/img1-top-floda3.jpg" alt="">
                            </a>
                            <figcaption class="banner-content">
                                <h2 class="text1">10% off</h2>
                                <h2 class="text2">tulip flower</h2>
                                <a class="store-link" href="#">buy it now</a>
                            </figcaption>
                        </figure>
                    </div>
                </div>
                <!-- start store item -->
            </div>
        </div>
    </section>
    <!-- banner statistics end -->

    <!-- service policy start -->
    <section class="service-policy-area section-space p-0">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-6 col-sm-6">
                    <!-- start policy single item -->
                    <div class="service-policy-item">
                        <div class="icons">
                            <img src="${path}/static/assets/img/icon/free_shipping.png" alt="">
                        </div>
                        <div class="policy-terms">
                            <h5>free shipping</h5>
                            <p>Free shipping all order</p>
                        </div>
                    </div>
                    <!-- end policy single item -->
                </div>
                <div class="col-lg-3 col-md-6 col-sm-6">
                    <!-- start policy single item -->
                    <div class="service-policy-item">
                        <div class="icons">
                            <img src="${path}/static/assets/img/icon/support247.png" alt="">
                        </div>
                        <div class="policy-terms">
                            <h5>SUPPORT 24/7</h5>
                            <p>Support 24 hours a day</p>
                        </div>
                    </div>
                    <!-- end policy single item -->
                </div>
                <div class="col-lg-3 col-md-6 col-sm-6">
                    <!-- start policy single item -->
                    <div class="service-policy-item">
                        <div class="icons">
                            <img src="${path}/static/assets/img/icon/money_back.png" alt="">
                        </div>
                        <div class="policy-terms">
                            <h5>Money Return</h5>
                            <p>30 days for free return</p>
                        </div>
                    </div>
                    <!-- end policy single item -->
                </div>
                <div class="col-lg-3 col-md-6 col-sm-6">
                    <!-- start policy single item -->
                    <div class="service-policy-item">
                        <div class="icons">
                            <img src="${path}/static/assets/img/icon/promotions.png" alt="">
                        </div>
                        <div class="policy-terms">
                            <h5>ORDER DISCOUNT</h5>
                            <p>On every order over $15</p>
                        </div>
                    </div>
                    <!-- end policy single item -->
                </div>
            </div>
        </div>
    </section>
    <!-- service policy end -->

    <!-- our product area start -->
    <section class="our-product section-space">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="section-title text-center">
                        <h2>New Products</h2>
                        <p>Accumsan vitae pede lacus ut ullamcorper sollicitudin quisque libero</p>
                    </div>
                </div>
            </div>
            <div class="row mtn-40">
                <!-- product single item start -->
                <div class="col-lg-3 col-md-4 col-sm-6">
                    <div class="product-item mt-40">
                        <figure class="product-thumb">
                            <a href="product-details.ftl">
                                <img class="pri-img" src="${path}/static/assets/img/product/product-1.jpg"
                                     alt="product">
                                <img class="sec-img" src="${path}/static/assets/img/product/product-2.jpg"
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
                                <a href="#" data-toggle="tooltip" data-placement="left" title="Add to wishlist"><i
                                            class="lnr lnr-heart"></i></a>
                                <a href="#" data-toggle="modal" data-target="#quick_view"><span data-toggle="tooltip"
                                                                                                data-placement="left"
                                                                                                title="Quick View"><i
                                                class="lnr lnr-magnifier"></i></span></a>
                                <a href="#" data-toggle="tooltip" data-placement="left" title="Add to Cart"><i
                                            class="lnr lnr-cart"></i></a>
                            </div>
                        </figure>
                        <div class="product-caption">
                            <p class="product-name">
                                <a href="product-details.ftl">Flowers bouquet pink</a>
                            </p>
                            <div class="price-box">
                                <span class="price-regular">$60.00</span>
                                <span class="price-old"><del>$70.00</del></span>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- product single item end -->

                <!-- product single item start -->
                <div class="col-lg-3 col-md-4 col-sm-6">
                    <div class="product-item mt-40">
                        <figure class="product-thumb">
                            <a href="product-details.ftl">
                                <img class="pri-img" src="${path}/static/assets/img/product/product-3.jpg"
                                     alt="product">
                                <img class="sec-img" src="${path}/static/assets/img/product/product-4.jpg"
                                     alt="product">
                            </a>
                            <div class="product-badge">
                                <div class="product-label new">
                                    <span>new</span>
                                </div>
                            </div>
                            <div class="button-group">
                                <a href="#" data-toggle="tooltip" data-placement="left" title="Add to wishlist"><i
                                            class="lnr lnr-heart"></i></a>
                                <a href="#" data-toggle="modal" data-target="#quick_view"><span data-toggle="tooltip"
                                                                                                data-placement="left"
                                                                                                title="Quick View"><i
                                                class="lnr lnr-magnifier"></i></span></a>
                                <a href="#" data-toggle="tooltip" data-placement="left" title="Add to Cart"><i
                                            class="lnr lnr-cart"></i></a>
                            </div>
                        </figure>
                        <div class="product-caption">
                            <p class="product-name">
                                <a href="product-details.ftl">Jasmine flowers white</a>
                            </p>
                            <div class="price-box">
                                <span class="price-regular">$60.00</span>
                                <span class="price-old"><del>$70.00</del></span>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- product single item end -->

                <!-- product single item start -->
                <div class="col-lg-3 col-md-4 col-sm-6">
                    <div class="product-item mt-40">
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
                                <a href="#" data-toggle="tooltip" data-placement="left" title="Add to wishlist"><i
                                            class="lnr lnr-heart"></i></a>
                                <a href="#" data-toggle="modal" data-target="#quick_view"><span data-toggle="tooltip"
                                                                                                data-placement="left"
                                                                                                title="Quick View"><i
                                                class="lnr lnr-magnifier"></i></span></a>
                                <a href="#" data-toggle="tooltip" data-placement="left" title="Add to Cart"><i
                                            class="lnr lnr-cart"></i></a>
                            </div>
                        </figure>
                        <div class="product-caption">
                            <p class="product-name">
                                <a href="product-details.ftl">Blossom bouquet flower</a>
                            </p>
                            <div class="price-box">
                                <span class="price-regular">$50.00</span>
                                <span class="price-old"><del>$80.00</del></span>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- product single item end -->

                <!-- product single item start -->
                <div class="col-lg-3 col-md-4 col-sm-6">
                    <div class="product-item mt-40">
                        <figure class="product-thumb">
                            <a href="product-details.ftl">
                                <img class="pri-img" src="${path}/static/assets/img/product/product-7.jpg"
                                     alt="product">
                                <img class="sec-img" src="${path}/static/assets/img/product/product-8.jpg"
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
                                <a href="#" data-toggle="tooltip" data-placement="left" title="Add to wishlist"><i
                                            class="lnr lnr-heart"></i></a>
                                <a href="#" data-toggle="modal" data-target="#quick_view"><span data-toggle="tooltip"
                                                                                                data-placement="left"
                                                                                                title="Quick View"><i
                                                class="lnr lnr-magnifier"></i></span></a>
                                <a href="#" data-toggle="tooltip" data-placement="left" title="Add to Cart"><i
                                            class="lnr lnr-cart"></i></a>
                            </div>
                        </figure>
                        <div class="product-caption">
                            <p class="product-name">
                                <a href="product-details.ftl">Hyacinth white stick</a>
                            </p>
                            <div class="price-box">
                                <span class="price-regular">$30.00</span>
                                <span class="price-old"><del>$55.00</del></span>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- product single item end -->

                <!-- product single item start -->
                <div class="col-lg-3 col-md-4 col-sm-6">
                    <div class="product-item mt-40">
                        <figure class="product-thumb">
                            <a href="product-details.ftl">
                                <img class="pri-img" src="${path}/static/assets/img/product/product-9.jpg"
                                     alt="product">
                                <img class="sec-img" src="${path}/static/assets/img/product/product-10.jpg"
                                     alt="product">
                            </a>
                            <div class="product-badge">
                                <div class="product-label new">
                                    <span>new</span>
                                </div>
                                <div class="product-label discount">
                                    <span>30%</span>
                                </div>
                            </div>
                            <div class="button-group">
                                <a href="#" data-toggle="tooltip" data-placement="left" title="Add to wishlist"><i
                                            class="lnr lnr-heart"></i></a>
                                <a href="#" data-toggle="modal" data-target="#quick_view"><span data-toggle="tooltip"
                                                                                                data-placement="left"
                                                                                                title="Quick View"><i
                                                class="lnr lnr-magnifier"></i></span></a>
                                <a href="#" data-toggle="tooltip" data-placement="left" title="Add to Cart"><i
                                            class="lnr lnr-cart"></i></a>
                            </div>
                        </figure>
                        <div class="product-caption">
                            <p class="product-name">
                                <a href="product-details.ftl">Orchid flower red stick</a>
                            </p>
                            <div class="price-box">
                                <span class="price-regular">$80.00</span>
                                <span class="price-old"><del>$90.00</del></span>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- product single item end -->

                <!-- product single item start -->
                <div class="col-lg-3 col-md-4 col-sm-6">
                    <div class="product-item mt-40">
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
                                <a href="#" data-toggle="tooltip" data-placement="left" title="Add to wishlist"><i
                                            class="lnr lnr-heart"></i></a>
                                <a href="#" data-toggle="modal" data-target="#quick_view"><span data-toggle="tooltip"
                                                                                                data-placement="left"
                                                                                                title="Quick View"><i
                                                class="lnr lnr-magnifier"></i></span></a>
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
                </div>
                <!-- product single item end -->

                <!-- product single item start -->
                <div class="col-lg-3 col-md-4 col-sm-6">
                    <div class="product-item mt-40">
                        <figure class="product-thumb">
                            <a href="product-details.ftl">
                                <img class="pri-img" src="${path}/static/assets/img/product/product-2.jpg"
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
                            <div class="button-group">
                                <a href="#" data-toggle="tooltip" data-placement="left" title="Add to wishlist"><i
                                            class="lnr lnr-heart"></i></a>
                                <a href="#" data-toggle="modal" data-target="#quick_view"><span data-toggle="tooltip"
                                                                                                data-placement="left"
                                                                                                title="Quick View"><i
                                                class="lnr lnr-magnifier"></i></span></a>
                                <a href="#" data-toggle="tooltip" data-placement="left" title="Add to Cart"><i
                                            class="lnr lnr-cart"></i></a>
                            </div>
                        </figure>
                        <div class="product-caption">
                            <p class="product-name">
                                <a href="product-details.ftl">Rose bouquet white</a>
                            </p>
                            <div class="price-box">
                                <span class="price-regular">$55.00</span>
                                <span class="price-old"><del>$80.00</del></span>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- product single item end -->

                <!-- product single item start -->
                <div class="col-lg-3 col-md-4 col-sm-6">
                    <div class="product-item mt-40">
                        <figure class="product-thumb">
                            <a href="product-details.ftl">
                                <img class="pri-img" src="${path}/static/assets/img/product/product-4.jpg"
                                     alt="product">
                                <img class="sec-img" src="${path}/static/assets/img/product/product-3.jpg"
                                     alt="product">
                            </a>
                            <div class="product-badge">
                                <div class="product-label discount">
                                    <span>10%</span>
                                </div>
                            </div>
                            <div class="button-group">
                                <a href="#" data-toggle="tooltip" data-placement="left" title="Add to wishlist"><i
                                            class="lnr lnr-heart"></i></a>
                                <a href="#" data-toggle="modal" data-target="#quick_view"><span data-toggle="tooltip"
                                                                                                data-placement="left"
                                                                                                title="Quick View"><i
                                                class="lnr lnr-magnifier"></i></span></a>
                                <a href="#" data-toggle="tooltip" data-placement="left" title="Add to Cart"><i
                                            class="lnr lnr-cart"></i></a>
                            </div>
                        </figure>
                        <div class="product-caption">
                            <p class="product-name">
                                <a href="product-details.ftl">Bouquet flowers pink</a>
                            </p>
                            <div class="price-box">
                                <span class="price-regular">$60.00</span>
                                <span class="price-old"><del>$70.00</del></span>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- product single item end -->

                <div class="col-12">
                    <div class="view-more-btn">
                        <a class="btn-hero btn-load-more" href="product.ftl">view more products</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- our product area end -->

    <!-- banner statistics start -->
    <section class="banner-statistics-right">
        <div class="container">
            <div class="row">
                <!-- start banner item start -->
                <div class="col-md-6">
                    <div class="banner-item banner-border">
                        <figure class="banner-thumb">
                            <a href="#">
                                <img src="${path}/static/assets/img/banner/banner-1.jpg" alt="">
                            </a>
                            <figcaption class="banner-content banner-content-right">
                                <h2 class="text1">for you</h2>
                                <h2 class="text2">Tulip Flower</h2>
                                <a class="store-link" href="#">shop now</a>
                            </figcaption>
                        </figure>
                    </div>
                </div>
                <!-- start banner item end -->

                <!-- start banner item start -->
                <div class="col-md-6">
                    <div class="banner-item banner-border">
                        <figure class="banner-thumb">
                            <a href="#">
                                <img src="${path}/static/assets/img/banner/banner-2.jpg" alt="">
                            </a>
                            <figcaption class="banner-content banner-content-right">
                                <h2 class="text1">for you</h2>
                                <h2 class="text2">Flower & Box</h2>
                                <a class="store-link" href="#">shop now</a>
                            </figcaption>
                        </figure>
                    </div>
                </div>
                <!-- start banner item end -->
            </div>
        </div>
    </section>
    <!-- banner statistics end -->

    <!-- trending product area start -->
    <section class="top-sellers section-space">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="section-title text-center">
                        <h2>top seller</h2>
                        <p>Accumsan vitae pede lacus ut ullamcorper sollicitudin quisque libero</p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="product-carousel--4 slick-row-15 slick-sm-row-10 slick-arrow-style">
                        <!-- product single item start -->
                        <div class="product-item">
                            <figure class="product-thumb">
                                <a href="product-details.ftl">
                                    <img class="pri-img" src="${path}/static/assets/img/product/product-9.jpg"
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
                                    <a href="#" data-toggle="tooltip" data-placement="left" title="Add to wishlist"><i
                                                class="lnr lnr-heart"></i></a>
                                    <a href="#" data-toggle="modal" data-target="#quick_view"><span
                                                data-toggle="tooltip" data-placement="left" title="Quick View"><i
                                                    class="lnr lnr-magnifier"></i></span></a>
                                    <a href="#" data-toggle="tooltip" data-placement="left" title="Add to Cart"><i
                                                class="lnr lnr-cart"></i></a>
                                </div>
                            </figure>
                            <div class="product-caption">
                                <p class="product-name">
                                    <a href="product-details.ftl">Blossom bouquet flower</a>
                                </p>
                                <div class="price-box">
                                    <span class="price-regular">$50.00</span>
                                    <span class="price-old"><del>$80.00</del></span>
                                </div>
                            </div>
                        </div>
                        <!-- product single item end -->

                        <!-- product single item start -->
                        <div class="product-item">
                            <figure class="product-thumb">
                                <a href="product-details.ftl">
                                    <img class="pri-img" src="${path}/static/assets/img/product/product-10.jpg"
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
                                <div class="button-group">
                                    <a href="#" data-toggle="tooltip" data-placement="left" title="Add to wishlist"><i
                                                class="lnr lnr-heart"></i></a>
                                    <a href="#" data-toggle="modal" data-target="#quick_view"><span
                                                data-toggle="tooltip" data-placement="left" title="Quick View"><i
                                                    class="lnr lnr-magnifier"></i></span></a>
                                    <a href="#" data-toggle="tooltip" data-placement="left" title="Add to Cart"><i
                                                class="lnr lnr-cart"></i></a>
                                </div>
                            </figure>
                            <div class="product-caption">
                                <p class="product-name">
                                    <a href="product-details.ftl">Rose bouquet white</a>
                                </p>
                                <div class="price-box">
                                    <span class="price-regular">$55.00</span>
                                    <span class="price-old"><del>$80.00</del></span>
                                </div>
                            </div>
                        </div>
                        <!-- product single item end -->

                        <!-- product single item start -->
                        <div class="product-item">
                            <figure class="product-thumb">
                                <a href="product-details.ftl">
                                    <img class="pri-img" src="${path}/static/assets/img/product/product-11.jpg"
                                         alt="product">
                                    <img class="sec-img" src="${path}/static/assets/img/product/product-8.jpg"
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
                                    <a href="#" data-toggle="tooltip" data-placement="left" title="Add to wishlist"><i
                                                class="lnr lnr-heart"></i></a>
                                    <a href="#" data-toggle="modal" data-target="#quick_view"><span
                                                data-toggle="tooltip" data-placement="left" title="Quick View"><i
                                                    class="lnr lnr-magnifier"></i></span></a>
                                    <a href="#" data-toggle="tooltip" data-placement="left" title="Add to Cart"><i
                                                class="lnr lnr-cart"></i></a>
                                </div>
                            </figure>
                            <div class="product-caption">
                                <p class="product-name">
                                    <a href="product-details.ftl">Hyacinth white stick</a>
                                </p>
                                <div class="price-box">
                                    <span class="price-regular">$30.00</span>
                                    <span class="price-old"><del>$55.00</del></span>
                                </div>
                            </div>
                        </div>
                        <!-- product single item end -->

                        <!-- product single item start -->
                        <div class="product-item">
                            <figure class="product-thumb">
                                <a href="product-details.ftl">
                                    <img class="pri-img" src="${path}/static/assets/img/product/product-12.jpg"
                                         alt="product">
                                    <img class="sec-img" src="${path}/static/assets/img/product/product-2.jpg"
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
                                    <a href="#" data-toggle="tooltip" data-placement="left" title="Add to wishlist"><i
                                                class="lnr lnr-heart"></i></a>
                                    <a href="#" data-toggle="modal" data-target="#quick_view"><span
                                                data-toggle="tooltip" data-placement="left" title="Quick View"><i
                                                    class="lnr lnr-magnifier"></i></span></a>
                                    <a href="#" data-toggle="tooltip" data-placement="left" title="Add to Cart"><i
                                                class="lnr lnr-cart"></i></a>
                                </div>
                            </figure>
                            <div class="product-caption">
                                <p class="product-name">
                                    <a href="product-details.ftl">Flowers bouquet pink</a>
                                </p>
                                <div class="price-box">
                                    <span class="price-regular">$60.00</span>
                                    <span class="price-old"><del>$70.00</del></span>
                                </div>
                            </div>
                        </div>
                        <!-- product single item end -->

                        <!-- product single item start -->
                        <div class="product-item">
                            <figure class="product-thumb">
                                <a href="product-details.ftl">
                                    <img class="pri-img" src="${path}/static/assets/img/product/product-4.jpg"
                                         alt="product">
                                    <img class="sec-img" src="${path}/static/assets/img/product/product-3.jpg"
                                         alt="product">
                                </a>
                                <div class="product-badge">
                                    <div class="product-label discount">
                                        <span>10%</span>
                                    </div>
                                </div>
                                <div class="button-group">
                                    <a href="#" data-toggle="tooltip" data-placement="left" title="Add to wishlist"><i
                                                class="lnr lnr-heart"></i></a>
                                    <a href="#" data-toggle="modal" data-target="#quick_view"><span
                                                data-toggle="tooltip" data-placement="left" title="Quick View"><i
                                                    class="lnr lnr-magnifier"></i></span></a>
                                    <a href="#" data-toggle="tooltip" data-placement="left" title="Add to Cart"><i
                                                class="lnr lnr-cart"></i></a>
                                </div>
                            </figure>
                            <div class="product-caption">
                                <p class="product-name">
                                    <a href="product-details.ftl">Bouquet flowers pink</a>
                                </p>
                                <div class="price-box">
                                    <span class="price-regular">$60.00</span>
                                    <span class="price-old"><del>$70.00</del></span>
                                </div>
                            </div>
                        </div>
                        <!-- product single item end -->

                        <!-- product single item start -->
                        <div class="product-item">
                            <figure class="product-thumb">
                                <a href="product-details.ftl">
                                    <img class="pri-img" src="${path}/static/assets/img/product/product-9.jpg"
                                         alt="product">
                                    <img class="sec-img" src="${path}/static/assets/img/product/product-10.jpg"
                                         alt="product">
                                </a>
                                <div class="product-badge">
                                    <div class="product-label new">
                                        <span>new</span>
                                    </div>
                                    <div class="product-label discount">
                                        <span>30%</span>
                                    </div>
                                </div>
                                <div class="button-group">
                                    <a href="#" data-toggle="tooltip" data-placement="left" title="Add to wishlist"><i
                                                class="lnr lnr-heart"></i></a>
                                    <a href="#" data-toggle="modal" data-target="#quick_view"><span
                                                data-toggle="tooltip" data-placement="left" title="Quick View"><i
                                                    class="lnr lnr-magnifier"></i></span></a>
                                    <a href="#" data-toggle="tooltip" data-placement="left" title="Add to Cart"><i
                                                class="lnr lnr-cart"></i></a>
                                </div>
                            </figure>
                            <div class="product-caption">
                                <p class="product-name">
                                    <a href="product-details.ftl">Orchid flower red stick</a>
                                </p>
                                <div class="price-box">
                                    <span class="price-regular">$80.00</span>
                                    <span class="price-old"><del>$90.00</del></span>
                                </div>
                            </div>
                        </div>
                        <!-- product single item end -->
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- trending product area end -->

    <!-- Instagram Feed Area Start -->
    <div class="instagram-feed-area">
        <div class="instagram-feed-thumb">
            <div id="instafeed" class="instagram-carousel" data-userid="6666969077"
                 data-accesstoken="6666969077.1677ed0.d325f406d94c4dfab939137c5c2cc6c2">
            </div>
        </div>
    </div>
    <!-- Instagram Feed Area End -->

</main>
<!-- main wrapper end -->
<div class="se-kl">
    <div class="se-cn">倒计时</div>
    <div class="se-en">COUNT DOWN</div>
    <i class="se-io"></i>
    <div class="se-info">距离结束还剩</div>
    <div class="se-count">
        <div class="se-day"></div>
        <div class="se-hour"><span class="se-txt">00</span></div>
        <div class="se-min"><span class="se-txt">00</span></div>
        <div class="se-sec"><span class="se-txt">00</span></div>
    </div>
</div>

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
                        <p>Copyright &copy; 2019.Company name All rights reserved
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

<script src="${path}/static/assets/js/vendor.js"></script>
<!-- Active Js -->
<script src="${path}/static/assets/js/active.js"></script>

<script src="${path}/static/js/jquery-3.0.0.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        let oDate = new Date();
        let nowTime = oDate.getTime(); //现在的毫秒数
        oDate.setDate(oDate.getDate() + 1); // 设定截止时间为第二天
        let targetDate = new Date(oDate.toLocaleDateString());
        run(targetDate);
    });

    function run(enddate) {
        getDate(enddate);
        setInterval("getDate('" + enddate + "')", 500);
    }

    function getDate(enddate) {
        let oDate = new Date(); //获取日期对象

        let nowTime = oDate.getTime(); //现在的毫秒数
        var enddate = new Date(enddate);
        let targetTime = enddate.getTime(); // 截止时间的毫秒数
        let second = Math.floor((targetTime - nowTime) / 1000); //截止时间距离现在的秒数

        let day = Math.floor(second / 24 * 60 * 60); //整数部分代表的是天；一天有24*60*60=86400秒 ；
        second = second % 86400; //余数代表剩下的秒数；
        let hour = Math.floor(second / 3600); //整数部分代表小时；
        second %= 3600; //余数代表 剩下的秒数；
        let minute = Math.floor(second / 60);
        second %= 60;
        let spanH = $('.se-txt')[0];
        let spanM = $('.se-txt')[1];
        let spanS = $('.se-txt')[2];

        spanH.innerHTML = tow(hour);
        spanM.innerHTML = tow(minute);
        spanS.innerHTML = tow(second);
    }

    function tow(n) {
        return n >= 0 && n < 10 ? '0' + n : '' + n;
    }
</script>

</body>

</html>
