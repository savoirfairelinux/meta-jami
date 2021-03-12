SUMMARY = "RESTinio is a header-only C++14 library that gives you an embedded HTTP/Websocket server."
LICENSE = "BSD-3-Clause"

LIC_FILES_CHKSUM = "file://../LICENSE;md5=f399b62ce0a152525d1589a5a40c0ff6"

SRC_URI = "https://github.com/Stiffstream/${PN}/releases/download/v.${PV}/${BPN}-${PV}.tar.bz2"
SRC_URI[sha256sum] = "b35d696e6fafd4563ca708fcecf9d0cf6705c846d417b5000f5252e0188848e7"

S = "${WORKDIR}/${PN}-${PV}/dev"

DEPENDS = "fmt asio http-parser"

EXTRA_OECMAKE = "-DRESTINIO_TEST=OFF \
                 -DRESTINIO_SAMPLE=OFF \
                 -DRESTINIO_INSTALL_SAMPLES=OFF \
                 -DRESTINIO_BENCH=OFF \
                 -DRESTINIO_INSTALL_BENCHES=OFF \
                 -DRESTINIO_FIND_DEPS=ON \
                 -DRESTINIO_ALLOW_SOBJECTIZER=OFF \
                 -DRESTINIO_USE_BOOST_ASIO=none \
                 -DRESTINIO_USE_EXTERNAL_HTTP_PARSER=ON \
"
inherit cmake
