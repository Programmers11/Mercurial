Update `booking` set gst = (gst * 100/(100-discount)) where gst>0

Update `booking` set amount = amount+gst where gst>0

Update `booking` set gst = 14 where gst>0
