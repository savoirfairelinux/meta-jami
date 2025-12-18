EXTRA_OECMAKE = "-DCMAKE_BUILD_TYPE=Release \
                 -DBUILD_SHARED_LIBS=OFF \
                 -DBUILD_CODE_GEN=ON \
                 -DBUILD_LIBSYSTEMD=OFF \
                 -DBUILD_TESTS=OFF \
                 -DBUILD_EXAMPLES=OFF \
                 -DBUILD_DOC=OFF \
                 "
EXTRA_OECONF:append = " \
        --enable-shared \
        --enable-pic \
        --enable-sdbus-c++-xml2cpp \
        --enable-adaptor \
        "
