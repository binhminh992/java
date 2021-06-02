import java.util.Scanner;

/*
 * Mục đích: Quản lý các nghiệp vụ liên quan đến nhân viên
 * Người tạo: Minh
 * Ngày tạo: 01/06/2021
 * Version: 1.0
 */
public class NhanVien {
	// Attributes
	private int maNhanVien;
	private String tenNhanVien;
	private int namSinh;
	private String diaChi;
	private float heSoLuong;
	final float luongCoSo = 1490000;
	private float thuong;
	private float luongHienHuong;

	// Get, set methods
	public int getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(int maNhanVien) {
		if (maNhanVien >= 0) {
			this.maNhanVien = maNhanVien;
		}
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		if (namSinh > 1900) {
			this.namSinh = namSinh;
		}
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public float getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(float heSoLuong) {
		if (heSoLuong > 0) {
			this.heSoLuong = heSoLuong;
		}
	}

	public float getLuongCoSo() {
		return luongCoSo;
	}

	public float getThuong() {
		return thuong;
	}

	public void setThuong(float thuong) {
		if (thuong >= 0) {
			this.thuong = thuong;
		}
	}

	public float getLuongHienHuong() {
		return luongHienHuong;
	}

	// Constructor methods
	public NhanVien() {

	}

	public NhanVien(int maNhanVien, String tenNhanVien, int namSinh, String diaChi, float heSoLuong, float thuong) {
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.namSinh = namSinh;
		this.diaChi = diaChi;
		this.heSoLuong = heSoLuong;
		this.thuong = thuong;
	}

	public NhanVien(int maNhanVien, String tenNhanVien, int namSinh, String diaChi) {
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.namSinh = namSinh;
		this.diaChi = diaChi;
	}

	public NhanVien(float heSoLuong, float thuong) {
		this.heSoLuong = heSoLuong;
		this.thuong = thuong;
	}

	public NhanVien(int maNhanVien, String tenNhanVien, int namSinh, String diaChi, float heSoLuong) {
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.namSinh = namSinh;
		this.diaChi = diaChi;
		this.heSoLuong = heSoLuong;
	}

	// Input, output methods
	public void nhapNV(Scanner scan) {
		System.out.print("Mã nhân viên: ");
		this.maNhanVien = Integer.parseInt(scan.nextLine());
		System.out.print("Tên nhân viên: ");
		this.tenNhanVien = scan.nextLine();
		System.out.print("Năm sinh: ");
		this.namSinh = Integer.parseInt(scan.nextLine());
		System.out.print("Địa chỉ: ");
		this.diaChi = scan.nextLine();
		System.out.print("Hệ số lương: ");
		this.heSoLuong = Float.parseFloat(scan.nextLine());
		System.out.print("Thưởng: ");
		this.thuong = Float.parseFloat(scan.nextLine());
	}

	public void xuat() {
		String lhh = String.format("%,.0f", luongHienHuong);
		System.out.println("Mã NV: " + this.maNhanVien + " | " + "Tên NV: " + this.tenNhanVien + " | " + "Năm sinh: "
				+ this.namSinh + " | " + "Địa chỉ: " + this.diaChi + " | " + "Hệ số lương: " + this.heSoLuong + " | "
				+ "Lương cơ sở: " + this.luongCoSo + " | " + "Thưởng: " + this.thuong + " | " + "Lương hiện hưởng: "
				+ lhh);
	}

	// Business methods
	public void tinhLuongHienHuong() {
		this.luongHienHuong = (this.heSoLuong * this.luongCoSo) + this.thuong;
	}

	// Format
	private String formatNumCell(Number num) {
		String paddLeft = "%2s";
		String paddRight = "%-8s";
		return String.format(paddLeft, " ") + String.format(paddRight, " " + num);
	}

	private String formatNumCell2(String num) {
		String paddLeft = "%3s";
		String paddRight = "%-12s";
		return String.format(paddLeft, " ") + String.format(paddRight, " " + num);
	}

	private String formatTextCell(String text) {
		String paddRight = "%-10s";
		return String.format(paddRight, "" + text);
	}

	public void xuatRowNhanVien() {
		String row;

		row = formatNumCell(this.maNhanVien) + "|";
		row += formatTextCell(this.tenNhanVien) + "|";
		row += formatNumCell(this.namSinh) + "|";
		row += formatTextCell(this.diaChi) + "  |";
		row += formatNumCell(this.heSoLuong) + "|";

		String lcs = String.format("%,.0f", this.luongCoSo);
		row += formatNumCell2(lcs) + "|";

		String thuong = String.format("%,.0f", this.thuong);
		row += formatNumCell2(thuong) + "|";

		String lhh = String.format("%,.0f", this.luongHienHuong);
		row += " " + formatNumCell2(lhh) + "  ||";

		System.out.println(row);
	}
}
