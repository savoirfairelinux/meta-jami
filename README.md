meta-jami
=========

This layer provides support for the open source communication platform Jami.
Jami is a free and open source audio, video and text peer-to-peer communication
platform. It does not require a server, and implements distributed and secure
end-to-end encrypted communications for multiple platforms.
Website: https://jami.net/

To enable Jami, add jami-client-qt to your IMAGE_INSTALL.

        IMAGE_INSTALL += "jami-client-qt"

Dependencies
------------
This layer depends on:

URI: git://github.com/openembedded/openembedded-core.git
branch: master
revision: 10221e578ffb3551ccefe15a523ceba0d289c086
prio: default

URI: git://github.com/openembedded/meta-openembedded.git
branch: master
revision: 698748c1538ed03efbcfdd936cf8317b4f138c29
layers: meta-oe
        meta-networking
        meta-multimedia
prio: default

URI: git://github.com/meta-qt5/meta-qt5.git
branch: master
revision: 7a9f639fbd632dbe23af95c7b8123a0b907c6179
prio: default

URI: git://git.openembedded.org/meta-python2
branch: master
revision: c43c29e57f16af4e77441b201855321fbd546661
prio: default

Community / Colaboration
------------------------

Repository: https://github.com/savoirfairelinux/meta-jami

Maintenance
-----------

Send pull requests, patches, comments or questions on GitHub.

License
-------

All metadata is GPL-3.0 licensed unless otherwise stated. Source code included
in tree for individual recipes is under the LICENSE stated in each recipe
(.bb file) unless otherwise stated.
