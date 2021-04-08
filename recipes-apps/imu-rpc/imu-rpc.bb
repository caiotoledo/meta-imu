SUMMARY = "Server and Client IMU application using RPC communication"
HOMEPAGE = "https://github.com/caiotoledo/imu-rpc"
SECTION = "Application"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=fbe1a119bfcf3a8d657029c25032df83"

INITSCRIPT_NAME = "init-imudaemon"
INITSCRIPT_PARAMS = "defaults 99 10"

FILEEXTRAPATHS_prepend = "${THISDIR}/files"
SRC_URI = "\
	git://github.com/caiotoledo/imu-rpc.git;branch=master \
	file://init-imudaemon \
"
SRCREV = "dd2c1e72a06560e2a4b4460c2ed666274d96e98f"

DEPENDS = "dbus-cxx"
RDEPENDS_${PN} = "dbus-cxx"

S = "${WORKDIR}/git/"

do_install_append() {
	install -d ${D}/etc/init.d
	install -m 0755 ${WORKDIR}/init-imudaemon ${D}/etc/init.d/
}

inherit pkgconfig cmake update-rc.d

OECMAKE_FIND_ROOT_PATH_MODE_PROGRAM = "BOTH"
