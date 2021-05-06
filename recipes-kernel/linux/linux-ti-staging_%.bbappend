FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

FILES_FOR_BBB_BBGW = "\
	file://imu-config.cfg \
	file://am335x-bone-imu.dtsi;subdir=git/arch/${ARCH}/boot/dts \
	file://add-bone-imu-dtsi.patch \
"
SRC_URI_append_beaglebone = "${FILES_FOR_BBB_BBGW}"

# Append kernel configuration for MPU6050
KERNEL_CONFIG_FRAGMENTS_append = "\
	${WORKDIR}/imu-config.cfg \
"

# Load MPU6050 Driver at startup
KERNEL_MODULE_AUTOLOAD_append = "inv-mpu6050-i2c"
