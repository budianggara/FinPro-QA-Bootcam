Feature: Defect Reporting Module LMS B2B Dibimbing

  Scenario: TC-BUG-001 - Mengirim Laporan Bug Valid dengan Bukti Gambar
    Given User sudah masuk ke halaman laporan bug LMS Dibimbing
    When User mengisi judul bug "Typo kata sukses pada notifikasi Add Class"
    And User memilih tingkat keparahan "Medium"
    And User memasukkan langkah reproduksi bug "1. Buka Add Class 2. Isi form 3. Klik Save"
    And User mengunggah file bukti gambar bug "evidence_typo.png"
    And User klik tombol Kirim Laporan
    Then Sistem berhasil menyimpan laporan bug dan menampilkan pesan sukses "Laporan Berhasil Dikirim"

  Scenario: TC-BUG-002 - Validasi Kolom Wajib pada Laporan Bug Gagal Dikirim
    Given User sudah masuk ke halaman laporan bug LMS Dibimbing
    When User mengosongkan semua kolom input laporan bug
    And User klik tombol Kirim Laporan
    Then Sistem menolak pengiriman dan menampilkan pesan peringatan "Semua kolom wajib diisi!"
