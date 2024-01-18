import java.io.File;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class InputParseFile {

        private String firstName;
        private String lastName;
        private String middleName;
        private String birthDate;
        private long numberPhone;
        private char gender;
        private final Scanner scan = new Scanner(System.in);
        String[] words;
        String[] date;



    private void EnterUserString() {
            System.out.println("Введите строку с данными разделенными пробелами в формате:\n" +
                    "Фамилия Имя Отчество ДатаРождения(dd.mm.yyyy) Телефон Пол(f/m)");
            String s = scan.nextLine();
            words = s.split(" ");
            if (s.equals("")) {
                throw new RuntimeException("Вводимое значение не может быть пустым,\nпопробуйте снова!");
            }
        }

        private void ParseUserString() {
            if (words.length != 6) {
                throw new RuntimeException("Вводимое значение строки с данными не могут быть пустыми и должны быть " +
                        "в формате\nФамилия Имя Отчество ДатаРождения(dd.mm.yyyy) Телефон Пол(f/m)\n" +
                        "nпопробуйте снова!");
            }
        }

        // Методы для присваивания значений полям
        private void EnterFirstName() {
            firstName = words[1];
            if (firstName.equals("")) {
                throw new RuntimeException("Вводимое значение Имя не может быть пустым,\nпопробуйте снова!");
            }
        }

        private void EnterLastName() {
            lastName = words[0];
            if (lastName.equals("")) {
                throw new RuntimeException("Вводимое значение Фамилия не может быть пустым,\nпопробуйте снова!");
            }
        }

        private void EnterMiddleName() {
            middleName = words[2];
            if (middleName.equals("")) {
                throw new RuntimeException("Вводимое значение Отчество не может быть пустым,\nпопробуйте снова!");
            }
        }

        private void EnterBirthDate() {
            birthDate = words[3];
                date = birthDate.split("\\.");
            if (date[0].equals("")||date[1].equals("")||date[2].equals("")) {
                throw new RuntimeException("Задан неверный формат Дата Рождения, формат даты должен быть dd.mm.yyyy," +
                        "\nпопробуйте снова!");
            }
        }

    private void EnterNumberPhone() {
        try {
            System.out.println("Enter number phone:");
            String number = words[4];
            if (number.equals("")) {
                throw new RuntimeException("Вводимое значение Номер Телефона не может быть пустым,\nпопробуйте снова!");
            }
            numberPhone = Long.parseLong(number);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: Не верный формат, попробуйте снова!");
        }
    }

        private void EnterGender() {
            String gen;
            String f = "f";
            String m = "m";
            gen = words[5];
            if (gen.length() > 1) {
                throw new RuntimeException("Вы ввели слишком много символов в параметр Пол правильно - f/m" +
                        "\nпопробуйте снова!");
            }
            if (gen.equals(f) || gen.equals(m)) {
                gender = gen.charAt(0);
            } else {
                throw new RuntimeException("Вы ввели не тот символ!");
            }
        }

        // Метод для вывода в консоль получившихля значений
        private void OutPutData() {
            System.out.println("\nФамилия \t- \t" + lastName + "\n" + "Имя \t- \t" + firstName + "\n" +
                    "Отчество \t- \t" + middleName + "\n" + "Дата рождения \t- \t" + birthDate + "\n" +
                    "Номер телефона \t- \t" + numberPhone + "\n" + "Пол   \t- \t" + gender);
        }

        // Метод для соединения всех методов в один
        private void DataEnter() {
            EnterUserString();
            ParseUserString();
            EnterFirstName();
            EnterLastName();
            EnterMiddleName();
            EnterBirthDate();
            EnterNumberPhone();
            EnterGender();
            OutPutData();
        }

        // Метод для сохранения данных в файл
        public void SaveDataEnter() {
            DataEnter();
            String file = lastName + ".txt";
            final File dir = new File("data");
            try (FileWriter fw = new FileWriter(new File(dir, file), true)) {
                fw.write("<" + firstName + "> " + "<" + lastName + "> " + "<" + middleName + "> "  + "<" +
                        birthDate + "> " + "<" + numberPhone + "> " + "<" + gender + ">\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Геттеры для полей

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public String getBirthDate() {
            return birthDate;
        }

        public char getGender() {
            return gender;
        }
    }
