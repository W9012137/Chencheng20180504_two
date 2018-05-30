package chencheng.bwie.com.chencheng20180504_two.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.dou361.ijkplayer.widget.IjkVideoView;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
import com.facebook.drawee.view.SimpleDraweeView;

import chencheng.bwie.com.chencheng20180504_two.R;
import chencheng.bwie.com.chencheng20180504_two.bean.XiangBean;
import chencheng.bwie.com.chencheng20180504_two.presenter.DetaPreaenter;

/**
 * Created by dell on 2018/5/4.
 */

public class DeatliActivity extends AppCompatActivity implements IDetaliView, View.OnClickListener {
    PlayerView play;
    DetaPreaenter preaenter;
    private IjkVideoView mVideoView;
    private ImageView mIvTrumb;
    private LinearLayout mLlBg;
    private TextView mAppVideoStatusText;
    private ImageView mAppVideoReplayIcon;
    private LinearLayout mAppVideoReplay;
    /**
     * 继续
     */
    private TextView mAppVideoNetTieIcon;
    private LinearLayout mAppVideoNetTie;
    /**
     * 188Kb/s
     */
    private TextView mAppVideoSpeed;
    private LinearLayout mAppVideoLoading;
    private ImageView mAppVideoVolumeIcon;
    /**
     * 50%
     */
    private TextView mAppVideoVolume;
    private LinearLayout mAppVideoVolumeBox;
    private ImageView mAppVideoBrightnessIcon;
    /**
     * 50%
     */
    private TextView mAppVideoBrightness;
    private LinearLayout mAppVideoBrightnessBox;
    /**
     * 50%
     */
    private TextView mAppVideoFastForward;
    /**
     * 50%
     */
    private TextView mAppVideoFastForwardTarget;
    /**
     * 50%
     */
    private TextView mAppVideoFastForwardAll;
    private LinearLayout mAppVideoFastForwardBox;
    private FrameLayout mAppVideoCenterBox;
    private ImageView mAppVideoFinish;
    private TextView mAppVideoTitle;
    private ImageView mAppVideoMenu;
    private LinearLayout mAppVideoTopBox;
    private ImageView mAppVideoPlay;
    /**
     * 06:21
     */
    private TextView mAppVideoCurrentTimeFull;
    /**
     * 06:21
     */
    private TextView mAppVideoCurrentTimeLeft;
    /**
     * 10:10
     */
    private TextView mAppVideoEndTimeLeft;
    private LinearLayout mAppVideoLift;
    private SeekBar mAppVideoSeekBar;
    /**
     * 06:21
     */
    private TextView mAppVideoCurrentTime;
    /**
     * 10:10
     */
    private TextView mAppVideoEndTime;
    private LinearLayout mAppVideoCenter;
    /**
     * 10:10
     */
    private TextView mAppVideoEndTimeFull;
    private LinearLayout mAppVideoProcessPanl;
    /**
     * 标清
     */
    private TextView mAppVideoStream;
    private ImageView mIjkIvRotation;
    private ImageView mAppVideoFullscreen;
    private LinearLayout mLlBottomBar;
    private SeekBar mSimplePlayerVolumeController;
    private LinearLayout mSimplePlayerVolumeControllerContainer;
    private SeekBar mSimplePlayerBrightnessController;
    private LinearLayout mSimplePlayerBrightnessControllerContainer;
    private LinearLayout mSimplePlayerSettingsContainer;
    private ListView mSimplePlayerSelectStreamsList;
    private LinearLayout mSimplePlayerSelectStreamContainer;
    private ImageView mPlayIcon;
    private RelativeLayout mAppVideoBox;
    private SimpleDraweeView mSimpleDetails;
    /**
     * 标题
     */
    private TextView mTitle;
    /**
     * 价格
     */
    private TextView mPrice;
    /**
     * 加入购物车
     */
    private Button mAddCart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vivdo);
        initView();
        Intent intent =getIntent();
        int pid = intent.getIntExtra("pid",0);
        preaenter = new DetaPreaenter(this);
        preaenter.get(pid+"");
        preaenter = new DetaPreaenter(this);
        preaenter.ond();
        String url = "http://ips.ifeng.com/video19.ifeng.com/video09/2014/06/16/1989823-102-086-0009.mp4";
        play = new PlayerView(this)
                .setTitle("什么")
                .setScaleType(PlayStateParams.fitparent)
                .hideMenu(true)
                .forbidTouch(false)
                .setPlaySource(url);
        play.startPlay();
    }


    @Override
    public void showDetali(XiangBean xiangBean, String pid) {
        //设置数据
        String[] split = xiangBean.getData().getImages().split("\\|");
        mSimpleDetails.setImageURI(Uri.parse(split[0]));
        mTitle.setText(xiangBean.getData().getTitle());
        mPrice.setText(xiangBean.getData().getPrice() + "");
    }


    private void initView() {
        mVideoView = (IjkVideoView) findViewById(R.id.video_view);
        mIvTrumb = (ImageView) findViewById(R.id.iv_trumb);
        mLlBg = (LinearLayout) findViewById(R.id.ll_bg);
        mAppVideoStatusText = (TextView) findViewById(R.id.app_video_status_text);
        mAppVideoReplayIcon = (ImageView) findViewById(R.id.app_video_replay_icon);
        mAppVideoReplay = (LinearLayout) findViewById(R.id.app_video_replay);
        mAppVideoNetTieIcon = (TextView) findViewById(R.id.app_video_netTie_icon);
        mAppVideoNetTie = (LinearLayout) findViewById(R.id.app_video_netTie);
        mAppVideoSpeed = (TextView) findViewById(R.id.app_video_speed);
        mAppVideoLoading = (LinearLayout) findViewById(R.id.app_video_loading);
        mAppVideoVolumeIcon = (ImageView) findViewById(R.id.app_video_volume_icon);
        mAppVideoVolume = (TextView) findViewById(R.id.app_video_volume);
        mAppVideoVolumeBox = (LinearLayout) findViewById(R.id.app_video_volume_box);
        mAppVideoBrightnessIcon = (ImageView) findViewById(R.id.app_video_brightness_icon);
        mAppVideoBrightness = (TextView) findViewById(R.id.app_video_brightness);
        mAppVideoBrightnessBox = (LinearLayout) findViewById(R.id.app_video_brightness_box);
        mAppVideoFastForward = (TextView) findViewById(R.id.app_video_fastForward);
        mAppVideoFastForwardTarget = (TextView) findViewById(R.id.app_video_fastForward_target);
        mAppVideoFastForwardAll = (TextView) findViewById(R.id.app_video_fastForward_all);
        mAppVideoFastForwardBox = (LinearLayout) findViewById(R.id.app_video_fastForward_box);
        mAppVideoCenterBox = (FrameLayout) findViewById(R.id.app_video_center_box);
        mAppVideoFinish = (ImageView) findViewById(R.id.app_video_finish);
        mAppVideoTitle = (TextView) findViewById(R.id.app_video_title);
        mAppVideoMenu = (ImageView) findViewById(R.id.app_video_menu);
        mAppVideoTopBox = (LinearLayout) findViewById(R.id.app_video_top_box);
        mAppVideoPlay = (ImageView) findViewById(R.id.app_video_play);
        mAppVideoCurrentTimeFull = (TextView) findViewById(R.id.app_video_currentTime_full);
        mAppVideoCurrentTimeLeft = (TextView) findViewById(R.id.app_video_currentTime_left);
        mAppVideoEndTimeLeft = (TextView) findViewById(R.id.app_video_endTime_left);
        mAppVideoLift = (LinearLayout) findViewById(R.id.app_video_lift);
        mAppVideoSeekBar = (SeekBar) findViewById(R.id.app_video_seekBar);
        mAppVideoCurrentTime = (TextView) findViewById(R.id.app_video_currentTime);
        mAppVideoEndTime = (TextView) findViewById(R.id.app_video_endTime);
        mAppVideoCenter = (LinearLayout) findViewById(R.id.app_video_center);
        mAppVideoEndTimeFull = (TextView) findViewById(R.id.app_video_endTime_full);
        mAppVideoProcessPanl = (LinearLayout) findViewById(R.id.app_video_process_panl);
        mAppVideoStream = (TextView) findViewById(R.id.app_video_stream);
        mAppVideoStream.setOnClickListener(this);
        mIjkIvRotation = (ImageView) findViewById(R.id.ijk_iv_rotation);
        mAppVideoFullscreen = (ImageView) findViewById(R.id.app_video_fullscreen);
        mLlBottomBar = (LinearLayout) findViewById(R.id.ll_bottom_bar);
        mSimplePlayerVolumeController = (SeekBar) findViewById(R.id.simple_player_volume_controller);
        mSimplePlayerVolumeControllerContainer = (LinearLayout) findViewById(R.id.simple_player_volume_controller_container);
        mSimplePlayerBrightnessController = (SeekBar) findViewById(R.id.simple_player_brightness_controller);
        mSimplePlayerBrightnessControllerContainer = (LinearLayout) findViewById(R.id.simple_player_brightness_controller_container);
        mSimplePlayerSettingsContainer = (LinearLayout) findViewById(R.id.simple_player_settings_container);
        mSimplePlayerSelectStreamsList = (ListView) findViewById(R.id.simple_player_select_streams_list);
        mSimplePlayerSelectStreamContainer = (LinearLayout) findViewById(R.id.simple_player_select_stream_container);
        mPlayIcon = (ImageView) findViewById(R.id.play_icon);
        mAppVideoBox = (RelativeLayout) findViewById(R.id.app_video_box);
        mSimpleDetails = (SimpleDraweeView) findViewById(R.id.simpleDetails);
        mTitle = (TextView) findViewById(R.id.title);
        mPrice = (TextView) findViewById(R.id.price);
        mAddCart = (Button) findViewById(R.id.addCart);
        mAddCart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.app_video_stream:
                break;
            case R.id.addCart:
                startActivity(new Intent(this,UserActivity.class));
                break;
        }
    }

}
