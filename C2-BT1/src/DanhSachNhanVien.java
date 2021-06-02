import java.util.ArrayList;

/*
 * Mục đích: Quản lý các nghiệp vụ liên quan đến các danh sách nhân viên
 * Người tạo: Minh
 * Ngày tạo: 01/06/2021
 * Version: 1.0
 */
public class DanhSachNhanVien {
	// Attributes
	ArrayList<NhanVien> listNV;

	// Get, set methods
	public ArrayList<NhanVien> getListNV() {
		return listNV;
	}

	public void setListNV(ArrayList<NhanVien> listNV) {
		this.listNV = listNV;
	}

	// Constructor methods
	public DanhSachNhanVien() {
		defaultConstructor();
	}

	public void defaultConstructor() {
		this.listNV = new ArrayList<NhanVien>();
	}

	// Input, output methods
	public void themNV(NhanVien nv) {
		this.listNV.add(nv);
	}

	public void xuat() {
		for (NhanVien nv : this.listNV) {
			nv.xuat();
		}
	}

	// Business methods
	public void tinhLuongHienHuong() {
		for (NhanVien nv : this.listNV) {
			nv.tinhLuongHienHuong();
		}
	}

	public float tinhTongLuongNV() {
		float tongLuongNV = 0;
		for (NhanVien nv : this.listNV) {
			tongLuongNV += nv.getLuongHienHuong();
		}
		return tongLuongNV;
	}

	public ArrayList<NhanVien> taoDSNVLuongCaoNhat() {
		ArrayList<NhanVien> list = new ArrayList<NhanVien>();

		if (this.listNV.size() > 0) {
			NhanVien nvMax = this.listNV.get(0);
			int indexMax = 0;

			for (int i = 0; i < this.listNV.size(); i++) {
				NhanVien nvCurrent = this.listNV.get(i);
				if (nvCurrent.getLuongHienHuong() > nvMax.getLuongHienHuong()) {
					nvMax = nvCurrent;
					indexMax = i;
				}
			}

			for (int i = indexMax; i < this.listNV.size(); i++) {
				NhanVien nvCurrent = this.listNV.get(i);
				if (nvCurrent.getLuongHienHuong() == nvMax.getLuongHienHuong()) {
					list.add(nvCurrent);
				}
			}
		}
		return list;
	}

}
