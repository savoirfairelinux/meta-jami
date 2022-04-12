SUMMARY = "OpenDHT"
DESCRIPTION = "A lightweight C++14 Distributed Hash Table implementation."
LICENSE = "GPL-3.0"

LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "git://github.com/savoirfairelinux/opendht.git;branch=master;protocol=https"

SRCREV = "e6768edaf0d11d76684faa40c208884778baafaf"

S = "${WORKDIR}/git"

DEPENDS = " \
    fmt \
    asio \
    http-parser \
    restinio \
    libargon2 \
    openssl \
    gnutls \
    jsoncpp \
    msgpack-c \
    nettle \
    pkgconfig-native \
    msgpack-cpp \
"
RDEPENDS:${PN} = " \
    fmt \
    asio \
    zlib \
    http-parser \
    libargon2 \
    openssl \
    gnutls \
    jsoncpp \
    gnutls \
    msgpack-c \
    nettle \
"

EXTRA_OECMAKE = " \
    -DOPENDHT_TOOLS=OFF \
    -DOPENDHT_PROXY_SERVER=ON \
    -DOPENDHT_PROXY_CLIENT=ON \
"
inherit cmake
