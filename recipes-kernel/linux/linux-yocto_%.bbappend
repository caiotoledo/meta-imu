FILESEXTRAPATHS_prepend_beaglebone-green-wifi := "${THISDIR}/${MACHINE}:${THISDIR}/files:"
FILESEXTRAPATHS_prepend_beaglebone := "${THISDIR}/${MACHINE}:${THISDIR}/files:"

FILES_FOR_BBB_BBGW = "\
	file://defconfig \
	file://am335x-bone-common_mpu6050.patch \
"
SRC_URI_prepend_beaglebone = "${FILES_FOR_BBB_BBGW}"
SRC_URI_prepend_beaglebone-green-wifi = "${FILES_FOR_BBB_BBGW}"

KERNEL_DEVICETREE_append = "${@bb.utils.contains('MACHINE', 'beaglebone-green-wifi', " am335x-bonegreen-wireless.dtb", "", d )}"
# Load MPU6050 Driver at startup
KERNEL_MODULE_AUTOLOAD_append = "inv-mpu6050-i2c"
