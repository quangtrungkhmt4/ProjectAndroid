package com.example.quang.mohinhmvp.XuLyDangNhap;

public class PresenterLogicXuLyDangNhap implements PresenterImXuLyDangNhap {
    private ViewXuLyDangNhap viewXuLyDangNhap;

    public PresenterLogicXuLyDangNhap(ViewXuLyDangNhap viewXuLyDangNhap) {
        this.viewXuLyDangNhap = viewXuLyDangNhap;
    }

    @Override
    public void kiemTraDangNhap(String ten, String mk) {
        if (ten.equals("trung") && mk.equals("123")){
            viewXuLyDangNhap.dangNhapThanhCong();
        }else {
            viewXuLyDangNhap.dangNhapThatBai();
        }
    }
}
