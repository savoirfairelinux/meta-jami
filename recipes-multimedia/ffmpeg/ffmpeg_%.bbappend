DEPENDS += "libopus"

EXTRA_OECONF:append = " \
        --enable-libopus \
        --enable-shared \
        --enable-pic \
        "
