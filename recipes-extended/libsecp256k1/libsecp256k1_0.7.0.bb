SUMMARY = "Optimized C library for ECDSA signatures and secret/public key operations on curve secp256k1."
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://COPYING;md5=67330c75f8bf6a92f6f8a36ae669ba74"

SRC_URI = "git://github.com/bitcoin-core/secp256k1.git;protocol=https;nobranch=1"
SRCREV = "a660a4976efe880bae7982ee410b9e0dc59ac983"

S = "${WORKDIR}/git"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-tests --disable-exhaustive-tests"
