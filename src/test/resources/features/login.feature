Feature: Login Module LMS B2B Dibimbing

  Scenario: TC-LOG-001 - Login dengan Kredensial Valid
    Given User membuka halaman login LMS Dibimbing
    When User memasukkan email "arwendymelyn@dibimbing.id" dan password "s2et9bh6l"
    And User klik tombol Sign In
    Then User berhasil diarahkan ke dashboard

  Scenario Outline: Login dengan Kredensial Tidak Valid
    Given User membuka halaman login LMS Dibimbing
    When User memasukkan email "<email>" dan password "<password>"
    And User klik tombol Sign In
    Then Sistem menampilkan pesan kesalahan "<pesan_error>"

    Examples:

      | email                     | password | pesan_error                |
      | arwendymelyn@dibimbing.id | Salah456 | wrong username or password |
      | adminlms.com              | s2et9bh6l| wrong username or password |
