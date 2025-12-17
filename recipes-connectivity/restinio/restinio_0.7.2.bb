SUMMARY = "Header-only C++14 library that gives you an embedded HTTP server"
DESCRIPTION = "Cross-platform, efficient, customizable, and robust \
               asynchronous HTTP/WebSocket server C++14 library with the \
               right balance between performance and ease of use"
HOMEPAGE = "https://stiffstream.com/en/products/restinio.html"
SECTION = "libs"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=a225c1245e9ba2ef7e64370d19a0bdfb"
DEPENDS = "asio fmt llhttp expected-lite"

SRC_URI = "https://github.com/Stiffstream/restinio/releases/download/v.${PV}/${BP}.tar.bz2"
SRC_URI[md5sum] = "4e607699fa8f80d3ca1df497b61b2fcf"
SRC_URI[sha256sum] = "7ba3660ccf937eae55b35aba97d500e60a53baf3f2a24ee87a01b2ed6f2c08f4"

S = "${WORKDIR}/${BP}/dev"

inherit cmake

EXTRA_OECMAKE += "\
                  -DRESTINIO_TEST=OFF \
                  -DRESTINIO_SAMPLE=OFF \
                  -DRESTINIO_BENCHMARK=OFF \
                  -DRESTINIO_DEP_LLHTTP=find \
                  -DRESTINIO_DEP_FMT=find \
                  -DRESTINIO_DEP_EXPECTED_LITE=find \
                  -DRESTINIO_WITH_SOBJECTIZER=OFF \
                  "

# Header-only library
RDEPENDS:${PN}-dev = ""
RRECOMMENDS:${PN}-dbg = "${PN}-dev (= ${EXTENDPKGV})"
