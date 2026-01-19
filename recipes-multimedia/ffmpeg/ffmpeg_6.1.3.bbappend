FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

SRC_URI:append:arm = " file://0001-libswscale-arm-Don-t-assume-aligned-output-in-yuv2rg.patch"
