package tv.danmaku.ijk.media.player;


import java.util.Map;
import java.util.TreeMap;

public class IjkMediaCodecInfo {
    private final static String TAG = "IjkMediaCodecInfo";

    public static final int RANK_MAX = 1000;
    public static final int RANK_TESTED = 800;
    public static final int RANK_ACCEPTABLE = 700;
    public static final int RANK_LAST_CHANCE = 600;
    public static final int RANK_SECURE = 300;
    public static final int RANK_SOFTWARE = 200;
    public static final int RANK_NON_STANDARD = 100;
    public static final int RANK_NO_SENSE = 0;

    //public CodecDescription mCodecInfo;
    public int mRank = 0;
    public String mMimeType;

    private static Map<String, Integer> sKnownCodecList;

    private static synchronized Map<String, Integer> getKnownCodecList() {
        if (sKnownCodecList != null)
            return sKnownCodecList;

        sKnownCodecList = new TreeMap<String, Integer>(
                String.CASE_INSENSITIVE_ORDER);

        // ----- Nvidia -----
        // Tegra3
        // Nexus 7 (2012)
        // Tegra K1
        // Nexus 9
        sKnownCodecList.put("OMX.Nvidia.h264.decode", RANK_TESTED);
        sKnownCodecList.put("OMX.Nvidia.h264.decode.secure", RANK_SECURE);

        // ----- Intel -----
        // Atom Z3735
        // Teclast X98 Air
        sKnownCodecList.put("OMX.Intel.hw_vd.h264", RANK_TESTED + 1);
        // Atom Z2560
        // Dell Venue 7 3730
        sKnownCodecList.put("OMX.Intel.VideoDecoder.AVC", RANK_TESTED);

        // ----- Qualcomm -----
        // MSM8260
        // Xiaomi MI 1S
        sKnownCodecList.put("OMX.qcom.video.decoder.avc", RANK_TESTED);
        sKnownCodecList.put("OMX.ittiam.video.decoder.avc", RANK_NO_SENSE);

        // ----- Samsung -----
        // Exynos 3110
        // Nexus S
        sKnownCodecList.put("OMX.SEC.avc.dec", RANK_TESTED);
        sKnownCodecList.put("OMX.SEC.AVC.Decoder", RANK_TESTED - 1);
        // OMX.SEC.avcdec doesn't reorder output pictures on GT-9100
        sKnownCodecList.put("OMX.SEC.avcdec", RANK_TESTED - 2);
        sKnownCodecList.put("OMX.SEC.avc.sw.dec", RANK_SOFTWARE);
        // Exynos 5 ?
        sKnownCodecList.put("OMX.Exynos.avc.dec", RANK_TESTED);
        sKnownCodecList.put("OMX.Exynos.AVC.Decoder", RANK_TESTED - 1);

        // ------ Huawei hisilicon ------
        // Kirin 910, Mali 450 MP
        //  HONOR 3C (H30-L01)
        sKnownCodecList.put("OMX.k3.video.decoder.avc", RANK_TESTED);
        // Kirin 920, Mali T624
        //  HONOR 6
        sKnownCodecList.put("OMX.IMG.MSVDX.Decoder.AVC", RANK_TESTED);

        // ----- TI -----
        // TI OMAP4460
        // Galaxy Nexus
        sKnownCodecList.put("OMX.TI.DUCATI1.VIDEO.DECODER", RANK_TESTED);

        // ------ RockChip ------
        // Youku TVBox
        sKnownCodecList.put("OMX.rk.video_decoder.avc", RANK_TESTED);

        // ------ AMLogic -----
        // MiBox1, 1s, 2
        sKnownCodecList.put("OMX.amlogic.avc.decoder.awesome", RANK_TESTED);

        // ------ Marvell ------
        // Lenovo A788t
        sKnownCodecList.put("OMX.MARVELL.VIDEO.HW.CODA7542DECODER", RANK_TESTED);
        sKnownCodecList.put("OMX.MARVELL.VIDEO.H264DECODER", RANK_SOFTWARE);

        // ----- TODO: need test -----
        sKnownCodecList.remove("OMX.Action.Video.Decoder");
        sKnownCodecList.remove("OMX.allwinner.video.decoder.avc");
        sKnownCodecList.remove("OMX.BRCM.vc4.decoder.avc");
        sKnownCodecList.remove("OMX.brcm.video.h264.hw.decoder");
        sKnownCodecList.remove("OMX.brcm.video.h264.decoder");
        sKnownCodecList.remove("OMX.cosmo.video.decoder.avc");
        sKnownCodecList.remove("OMX.duos.h264.decoder");
        sKnownCodecList.remove("OMX.hantro.81x0.video.decoder");
        sKnownCodecList.remove("OMX.hantro.G1.video.decoder");
        sKnownCodecList.remove("OMX.hisi.video.decoder");
        sKnownCodecList.remove("OMX.LG.decoder.video.avc");
        sKnownCodecList.remove("OMX.MS.AVC.Decoder");
        sKnownCodecList.remove("OMX.RENESAS.VIDEO.DECODER.H264");
        sKnownCodecList.remove("OMX.RTK.video.decoder");
        sKnownCodecList.remove("OMX.sprd.h264.decoder");
        sKnownCodecList.remove("OMX.ST.VFM.H264Dec");
        sKnownCodecList.remove("OMX.vpu.video_decoder.avc");
        sKnownCodecList.remove("OMX.WMT.decoder.avc");

        // Really ?
        sKnownCodecList.remove("OMX.bluestacks.hw.decoder");

        // ---------------
        // Useless codec
        // ----- google -----
        sKnownCodecList.put("OMX.google.h264.decoder", RANK_SOFTWARE);
        sKnownCodecList.put("OMX.google.h264.lc.decoder", RANK_SOFTWARE);
        // -----  k920 -----
        sKnownCodecList.put("OMX.k3.ffmpeg.decoder", RANK_SOFTWARE);
        sKnownCodecList.put("OMX.ffmpeg.video.decoder", RANK_SOFTWARE);
        // ----- unknown -----
        sKnownCodecList.put("OMX.sprd.soft.h264.decoder", RANK_SOFTWARE);

        return sKnownCodecList;
    }
}
