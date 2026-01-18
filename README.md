# meta-jami

This layer provides support for the open-source communication platform Jami.
Jami is a free and open-source audio, video, and text peer-to-peer communication
platform. It does not require a server and implements distributed and secure
end-to-end encrypted communications for multiple platforms.
Website: https://jami.net/

To enable Jami, add jami-client-qt to your IMAGE_INSTALL.

        IMAGE_INSTALL += "jami-client-qt"

## Dependencies

This layer depends on:

URI: git@github.com:openembedded/bitbake.git
branch: master
revision: f1c4ac816e927f490fb9852c12aa408e8c9403b1
prio: default

URI: git://github.com/openembedded/openembedded-core.git
branch: master
revision: d1849a1facd64fa0bcf8336a0ed5fbf71b2e3cb5
prio: default

URI: git://github.com/openembedded/meta-openembedded.git
branch: master
revision: fe149bbb3689c3ed83eddfec46c9a54e86308cb9
layers: meta-oe
        meta-networking
        meta-multimedia
prio: default

URI: git://code.qt.io/yocto/meta-qt6.git
branch: 6.2.4
revision: f52e491cd9e56d0fc653fb32db1ccf78710e92dc
prio: default

URI: git://git.openembedded.org/meta-python2
branch: master
revision: f02882e2aa9279ca7becca8d0cedbffe88b5a253
prio: default

## Community/Collaboration

Repository: https://github.com/savoirfairelinux/meta-jami

## Maintenance

Send pull requests, patches, comments, or questions on GitHub.

## License

All metadata is GPL-3.0 licensed unless otherwise stated. Source code included
in the tree for individual recipes is under the LICENSE stated in each recipe
(.bb file) unless otherwise stated.
