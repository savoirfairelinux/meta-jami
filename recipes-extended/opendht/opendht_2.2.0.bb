SUMMARY = "OpenDHT"
DESCRIPTION = "A lightweight C++14 Distributed Hash Table implementation."
LICENSE = "GPL-3.0"

LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "https://github.com/savoirfairelinux/${BPN}/archive/${PV}.tar.gz"
SRC_URI[sha256sum] = "5ca454e0606227685b146f519964bab97e5d593909f65bc9c3940750a182891f"

S = "${WORKDIR}/${PN}-${PV}"

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
"
RDEPENDS_${PN} = " \
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
