DEPENDS:append = " libxkbcommon"
def limit_parallel(limit):
 import multiprocessing
 nproc = min(multiprocessing.cpu_count(), int(limit))
 return "-j{}".format(nproc)
PARALLEL_MAKE = "${@limit_parallel(8)}"
export NINJAJOBS = "${PARALLEL_MAKE}"

FILESEXTRAPATHS:prepend := "${THISDIR}/qtwebengine:"

SRC_URI += " \
        file://0001-host-fix-compilation-dependencies.patch \
"
