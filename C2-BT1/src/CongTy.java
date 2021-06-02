import java.util.ArrayList;
import java.util.Scanner;

/*
 * Mục đích: Quản lý các nghiệp vụ liên quan đến công ty
 * Người tạo: Minh
 * Ngày tạo: 01/06/2021
 * Version: 1.0
 */
public class CongTy {
	// Attributes
	DanhSachNhanVien dsnvToanCongTy;

	// Get, set methods
	public DanhSachNhanVien getDsnvToanCongTy() {
		return dsnvToanCongTy;
	}

	public void setDsnvToanCongTy(DanhSachNhanVien dsnvToanCongTy) {
		this.dsnvToanCongTy = dsnvToanCongTy;
	}

	// Constructor methods
	public CongTy() {
		defaultConstructor();
	}

	public void defaultConstructor() {
		this.dsnvToanCongTy = new DanhSachNhanVien();
	}

	// Input, output methods
	public void themNV(NhanVien nv) {
		this.dsnvToanCongTy.themNV(nv);
	}

	public void xuat() {
		this.dsnvToanCongTy.xuat();
	}

	public ArrayList<NhanVien> xuatList(ArrayList<NhanVien> list) {
		for (NhanVien nv : list) {
			nv.xuat();
		}
		return list;
	}

	public void generateDummyData() {
		NhanVien nv = new NhanVien(1, "Trang", 1992, "Hà Nội", 6.2f, 2000000);
		this.dsnvToanCongTy.themNV(nv);

		nv = new NhanVien(2, "Lâm", 1994, "Hải Dương", 8f, 1500000);
		this.dsnvToanCongTy.themNV(nv);

		nv = new NhanVien(3, "Long", 1985, "HCM", 6.2f, 758000);
		this.dsnvToanCongTy.themNV(nv);

		nv = new NhanVien(4, "Hà", 1982, "Nghệ An", 6.2f, 500000);
		this.dsnvToanCongTy.themNV(nv);

		nv = new NhanVien(5, "Dũng", 1996, "Hải Phòng", 4.74f, 475000);
		this.dsnvToanCongTy.themNV(nv);

		nv = new NhanVien(6, "Nam", 1997, "Thái Bình", 8f, 1500000);
		this.dsnvToanCongTy.themNV(nv);

		nv = new NhanVien(7, "Long", 1990, "Quảng Ninh", 4.74f, 1250000);
		this.dsnvToanCongTy.themNV(nv);

		nv = new NhanVien(8, "Huyền", 1992, "Hà Nội", 5.75f, 820000);
		this.dsnvToanCongTy.themNV(nv);

		nv = new NhanVien(9, "Ngọc", 1988, "Bắc Ninh", 5.42f, 682000);
		this.dsnvToanCongTy.themNV(nv);

		nv = new NhanVien(10, "Đức", 1998, "Hà Giang", 7.55f, 550000);
		this.dsnvToanCongTy.themNV(nv);

	}

	// Business methods
	public void tinhLuongHienHuong() {
		this.dsnvToanCongTy.tinhLuongHienHuong();
	}

	public float tinhTongLuongNV() {
		return this.dsnvToanCongTy.tinhTongLuongNV();
	}

	public ArrayList<NhanVien> taoDSNVLuongCaoNhat() {
		return this.dsnvToanCongTy.taoDSNVLuongCaoNhat();
	}

	// Format
	private void xuatLine() {
		System.out.println(
				"=======================================================================================================================");
	}

	private String formatCell(String paddLeft, String text, String paddRight) {
		return String.format(paddLeft, "") + text + String.format(paddRight, "");
	}

	private void xuatRowHeader() {
		String row;
		String padd1 = "%1s";
		String padd2 = "%2s";
		String padd3 = "%3s";
		String padd4 = "%4s";
		String padd5 = "%5s";

		xuatLine();
		row = "||" + formatCell(padd2, "STT", padd2) + "|";
		row += formatCell(padd2, "Mã NV", padd3) + "|";
		row += formatCell(padd3, "Tên", padd4) + "|";
		row += formatCell(padd1, "Năm sinh", padd1) + "|";
		row += formatCell(padd2, "Địa chỉ", padd3) + "|";
		row += formatCell(padd3, "Hệ số", padd2) + "|";
		row += formatCell(padd2, "Lương cơ sở", padd2) + "|";
		row += formatCell(padd5, "Thưởng", padd4) + "|";
		row += formatCell(padd1, "Lương hiện hưởng", padd1) + "||";
		System.out.println(row);
		xuatLine();
	}

	private void xuatCellThuTu(int i) {
		String paddLeft = "%2s";
		String paddRight = "%-5s";
		String cell = "||" + String.format(paddLeft, " ") + String.format(paddRight, " " + i) + "|";
		System.out.print(cell);
	}

	private void xuatRowTongLuongNV() {
		String tongLuongNV = String.format("%,.0f", this.dsnvToanCongTy.tinhTongLuongNV());

		String paddLeft = "%93s";
		String paddRight = "%-1s";

		String row = "||" + String.format(paddLeft, "") + "Tổng: " + tongLuongNV + " VNĐ" + String.format(paddRight, "")
				+ "||";
		System.out.println(row);
	}

	public void xuatTheoFormat(ArrayList<NhanVien> list) {
		int i = 1;
		xuatRowHeader();
		for (NhanVien nv : list) {
			xuatCellThuTu(i);
			nv.xuatRowNhanVien();
			i++;
		}
		xuatLine();
		xuatRowTongLuongNV();
		xuatLine();
	}
}
