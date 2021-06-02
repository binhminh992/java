import java.util.ArrayList;
import java.util.Scanner;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		CongTy ct = new CongTy();
		ct.generateDummyData();
		doMenu(scan, ct);
	}

	public static void inMenu() {
		System.out.println("Lựa chọn tính năng");
		System.out.println("1. Thêm nhân viên");
		System.out.println("2. Xuất danh sách nhân viên");
		System.out.println("3. Tính tổng tiền lương của toàn bộ nhân viên");
		System.out.println("4. Xuất danh sách các nhân viên lương cao nhất");
		System.out.println("0. Thoát");
	}

	public static void doMenu(Scanner scan, CongTy ct) {
		boolean flag = true;
		do {
			inMenu();
			System.out.print("Chọn: ");
			int n = Integer.parseInt(scan.nextLine());
			switch (n) {
			case 1:
				NhanVien nv = new NhanVien();
				nv.nhapNV(scan);
				ct.themNV(nv);
				break;
			case 2:
				ct.tinhLuongHienHuong();
				ct.xuatTheoFormat(ct.getDsnvToanCongTy().getListNV());
				break;
			case 3:
				String tongluongNV = String.format("%,.0f", ct.tinhTongLuongNV());
				System.out.println("Tổng lương nhân viên: " + tongluongNV + " VNĐ");
				break;
			case 4:
				ArrayList<NhanVien> list = ct.taoDSNVLuongCaoNhat();
				ct.xuatTheoFormat(list);
				break;
			case 0:
				flag = false;
				break;
			}

		} while (flag);
	}
}
