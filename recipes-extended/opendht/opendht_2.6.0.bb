SUMMARY = "OpenDHT"
DESCRIPTION = "A lightweight C++14 Distributed Hash Table implementation."
LICENSE = "GPL-3.0-only"

LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "git://github.com/savoirfairelinux/opendht.git;branch=master;protocol=https"

SRCREV = "7383e3ea29156ae1f677a7250b3ba18969e78bb2"

S = "${WORKDIR}/git"

DEPENDS = " \
    asio \
    cppunit \
    fmt \
    gnutls \
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
    gnutls \
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
