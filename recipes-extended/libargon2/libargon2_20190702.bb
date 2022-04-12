SUMMARY = "C implementation of Argon2"
LICENSE = "Apache-2.0"

LIC_FILES_CHKSUM = "file://LICENSE;md5=3f577d9446ded914cd9f8f0ae099a45a"

SRC_URI = "git://github.com/P-H-C/phc-winner-argon2.git;branch=master;protocol=https"
SRCREV = "62358ba2123abd17fccf2a108a301d4b52c01a7c"
S = "${WORKDIR}/git"

do_compile() {
	oe_runmake LIBRARY_REL=/lib
}

do_install() {
	oe_runmake LIBRARY_REL=/lib PREFIX="${D}${prefix}" install
}
