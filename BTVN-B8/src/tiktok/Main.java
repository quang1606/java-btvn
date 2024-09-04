 public boolean logGin(Scanner scanner, List<Register> registers) {
            String useName;
            String passWord;

            while (true) {
                System.out.println("Nhap usename: ");
                useName = scanner.nextLine();

                Register userRegister = findRegisterByUsername(registers, useName);

                if (userRegister != null) {
                    System.out.println("Nhap password: ");
                    passWord = scanner.nextLine();

                    if (userRegister.getPassWord().equals(passWord)) {
                        System.out.println("Chao mung "+userRegister.getUseName()+" ban co the thuc hien cong viec sau:");
                        return true;
                    } else {
                        while (true) {
                            System.out.println("Sai mat khau.");
                            System.out.println("1 - Dang nhap lai");
                            System.out.println("2 - Quen mat khau");
                            String choice = scanner.nextLine();

                            if ("1".equals(choice)) {
                                break;
                            } else if ("2".equals(choice)) {
                                return forgetPassword(scanner, userRegister);
                            } else {
                                System.out.println("Lua chon khong hop le. Vui long thu lai.");
                            }
                        }
                    }
                } else {
                    System.out.println("Kiem tra lai username!");
                }
            }
        }


        public boolean forgetPassword(Scanner scanner, Register userRegister) {
            System.out.println("Nhap email de xac nhan tai khoan: ");
            String email = scanner.nextLine();

            if (userRegister.getEmail().equals(email)) {
                System.out.println("Email dung. Nhap mat khau moi: ");
                String newPassword = scanner.nextLine();
                userRegister.setPassWord(newPassword);
                System.out.println("Doi mat khau thanh cong. Dang nhap lai.");
                return true;
            } else {
                System.out.println("Email khong ton tai. Vui long thu lai.");
                return false;
            }
        }

        private Register findRegisterByUsername(List<Register> registers, String useName) {
            for (Register register : registers) {
                if (register.getUseName().equals(useName)) {
                    return register;
                }
            }
            return null;
        }
    public void updateUseName(Scanner scanner, List<Register>registers, Register register){

        System.out.println("Nhap vao usename moi:");
        String useNameNew = scanner.nextLine();
        register.setUseName(useNameNew);
    }


     case 1:
                    if (logGinService.logGin(scanner,registers)){
                        selectDisplayMenuLogInSuccessfully(scanner,registers);
                    }else {
                        logGinService.logGin(scanner,registers);
                    }

                case 2:
                    Register register = registerService.register(scanner,registers);
                    registers.add(register);


                    break;
            }





                public  void selectMenu(Scanner scanner, List<Register> registers){
        do {
            displayMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    boolean loggedIn = false;
                    while (!loggedIn) {
                        LogGin logGin = logGinService.logGin(scanner);
                        if (logGinService.checkUseName(registers, logGin)) {
                            if (logGinService.checkPassword(registers, logGin)) {
                                System.out.println("Chào mừng bạn " + logGin.getUseName() + ", bạn có thể thực hiện công việc sau:");
                                loggedIn = true;
                            } else {
                                System.out.println("Sai mat khau!");
                              selectDisplayMenuLogGin(scanner,registers);
                            }
                        } else {
                            System.out.println("Kiểm tra lại username");
                        }
                    }
                    break;
                case 2:
                    Register register = registerService.register(scanner, registers);
                    registers.add(register);
                    break;

            }
        }while (true);
    }



    public void selectDisplayMenuLogGin(Scanner scanner, List<Register>registers){
        displayMenuLogGin();
    int choice=Integer.parseInt(scanner.nextLine());
    switch (choice){
        case 1:
            boolean loggedIn = false;
            while (!loggedIn) {
                LogGin logGin = logGinService.logGin(scanner);
                if (logGinService.checkUseName(registers, logGin)) {
                    if (logGinService.checkPassword(registers, logGin)) {
                        System.out.println("Chào mừng bạn " + logGin.getUseName() + ", bạn có thể thực hiện công việc sau:");
                        loggedIn = true;
                    } else {
                        System.out.println("Sai mat khau!");
                        selectDisplayMenuLogGin(scanner,registers);
                    }
                } else {
                    System.out.println("Kiểm tra lại username");
                }
            }
break;
        case 2:

            logGinService.forgetPassword(scanner,logGin,registers);
            break;
    }
}
