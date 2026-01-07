SUMMARY = "OpenDHT"
DESCRIPTION = "A lightweight C++17 Distributed Hash Table implementation."
LICENSE = "GPL-3.0-only"

LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "git://github.com/savoirfairelinux/opendht.git;branch=master;protocol=https"

SRCREV = "c60c6b8af2daff93dea0f8264c55cdff6b64a4f3"

S = "${WORKDIR}/git"

DEPENDS = " \
    asio \
    cppunit \
    fmt \
    gnutls \
    simdutf \
    llhttp \
    http-parser \
    jsoncpp \
    libargon2 \
    msgpack-c \
    msgpack-cpp \
    nettle \
    openssl \
    pkgconfig-native \
    restinio \
"
RDEPENDS:${PN} = " \
    asio \
    fmt \
    gnutls \
    simdutf \
    http-parser \
    jsoncpp \
    libargon2 \
    msgpack-c \
    nettle \
    openssl \
    zlib \
"

EXTRA_OECMAKE = " \
    -DOPENDHT_TOOLS=OFF \
    -DOPENDHT_PROXY_SERVER=ON \
    -DOPENDHT_PROXY_CLIENT=ON \
"
inherit cmake
