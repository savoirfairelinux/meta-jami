SUMMARY = "expected objects for C++11 and later"
DESCRIPTION = "expected lite is a single-file header-only library for objects that either represent \
a valid value or an error that you can pass by value. It is intended for use with C++11 and later."
LICENSE = "BSL-1.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=e4224ccaecb14d942c71d31bef20d78c"

SRC_URI = "git://github.com/nonstd-lite/expected-lite.git;protocol=https;branch=master"

PV = "0.6.3"
SRCREV = "c8ffab649ba56e43c731b7017a69ddaebe2e1893"

S = "${WORKDIR}/git"

inherit cmake
