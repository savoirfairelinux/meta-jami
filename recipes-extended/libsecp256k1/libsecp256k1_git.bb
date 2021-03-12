SUMMARY = "Optimized C library for ECDSA signatures and secret/public key operations on curve secp256k1."
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://COPYING;md5=67330c75f8bf6a92f6f8a36ae669ba74"

GIT_REV = "0b7024185045a49a1a6a4c5615bf31c94f63d9c4"
GIT_PROT = "protocol=https;nobranch=1"

SRC_URI = " \
    git://github.com/bitcoin-core/secp256k1.git;${GIT_PROT};rev=${GIT_REV} \
"
S = "${WORKDIR}/git"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-tests --disable-exhaustive-tests"
