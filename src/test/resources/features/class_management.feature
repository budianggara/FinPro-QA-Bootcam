Feature: Class Management Module LMS B2B Dibimbing

  Background: User sudah login dengan akun valid
    Given User membuka halaman login LMS Dibimbing
    When User memasukkan email "arwendymelyn@dibimbing.id" dan password "s2et9bh6l"
    And User klik tombol Sign In
    Then User berhasil diarahkan ke dashboard

  Scenario: TC-ADD-001 - Validasi Kolom Judul Kelas Kosong
    Given User menavigasi ke halaman form Tambah Kelas
    When User mengosongkan kolom Title Kelas
    And User klik tombol Selanjutnya
    Then Sistem menolak proses dan menampilkan toast alert "Title Class Tidak Boleh Kosong!"

  Scenario: TC-ADD-004 - Validasi Sukses Simpan Kelas Baru
    Given User menavigasi ke halaman form Tambah Kelas
    When User mengisi seluruh form data kelas baru secara lengkap
    And User klik tombol Simpan Kelas
    Then Sistem berhasil menyimpan kelas dan menampilkan toast notifikasi "Succes Save Changes"

   #------SKENARIO MANAGE, SEARCH, FILTER, DELETE & EDIT-----------

  #---------BISA---------------
  @ManageClass @SearchAndFilter
  Scenario: TC-MNG-005 - Validasi fungsi filter berdasarkan angkatan kelas
    Given User berada di halaman utama manajemen kelas
    When User klik tombol Filter by Angkatan
    And User memilih opsi "Ganjil 2025"
    Then Sistem menampilkan seluruh daftar kelas yang masuk angkatan ganjil dua ribu dua puluh lima

    #---------BISA-------
  @ManageClass @DeleteClass
  Scenario: TC-MNG-006 - Validasi hapus kelas dan verifikasi bug durasi toast alert
    Given User berada di halaman utama manajemen kelas
    When User mencari kelas kata kunci "class-test"
    And User melakukan hapus kelas dan konfirmasi


    #------BISA-------
  @EditClass @SubModule
  Scenario: TC-CLS-002 - Validasi perubahan detail informasi data angkatan kelas
    Given User berada di halaman utama manajemen kelas
    When User mencari kelas kata kunci "tqweqwd"
    And User klik tombol Edit dan Manage Content
    And User melakukan perubahan detail informasi angkatan menjadi dua ribu dua puluh empat
