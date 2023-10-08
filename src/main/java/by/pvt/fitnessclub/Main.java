package by.pvt.fitnessclub;

import by.pvt.fitnessclub.entity.Activities;
import by.pvt.fitnessclub.repository.jpa.*;
import by.pvt.fitnessclub.service.AttendanceService;
import by.pvt.fitnessclub.service.ClientService;
import by.pvt.fitnessclub.service.OfficeService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        ClientRepositoryHibernate clientRepositoryHibernate = new ClientRepositoryHibernate();
        VisitorRepositoryHibernate visitorRepositoryHibernate = new VisitorRepositoryHibernate();
        ClientService clientService = new ClientService(new ClientRepositoryHibernate());
        OfficeService officeService = new OfficeService(new OfficeRepositoryHibernate());
        AttendanceService attendanceService = new AttendanceService(new AttendanceRepositoryHibernate(visitorRepositoryHibernate));
        RecordsRepositoryHibernate recordsRepositoryHibernate = new RecordsRepositoryHibernate();
        AttendanceRepositoryHibernate attendanceRepositoryHibernate = new AttendanceRepositoryHibernate(visitorRepositoryHibernate);

        OfficeRepositoryHibernate officeRepositoryHibernate = new OfficeRepositoryHibernate();
//        officeRepositoryHibernate.addOffice(new Office("Тренажерный зал", 141455L, 15, OfficeStatus.ACTIVE, new BigDecimal(10.0)));
//        officeRepositoryHibernate.addOffice(new Office("Теннисный корт", 1654276L, 14, OfficeStatus.ACTIVE, new BigDecimal(23.0)));
//        officeRepositoryHibernate.addOffice(new Office("Футбольный зал", 3672341L, 10, OfficeStatus.ACTIVE, new BigDecimal(16.0)));
//        officeRepositoryHibernate.addOfficeWithInventoryNumber(9L, 123456L);

//        System.out.println(officeRepositoryHibernate.updateCountOfPeople(9L, 20));
//        officeRepositoryHibernate.delete(1L);
//        System.out.println(officeRepositoryHibernate.updatePriceForHour(9L, new BigDecimal(15.0)));
//        System.out.println(officeRepositoryHibernate.priceForOffices(9L));
//        System.out.println(officeService.getSmallOffices());

//        System.out.println(clientService.getAllClients());
//        System.out.println(officeService.getSmallOfficesPrices());

//        attendanceService.addAttendance(new Attendance(null, 1L, LocalDate.of(23, 6, 24), new BigDecimal(17), 1L));
//
//        Client client = new Client();
//        client.setName("Артур");
//        client.setSurname("Ионов");
//        client.setTelephone("+375294762235");
//        client.setAge(36);
//        client.setLastVisit(LocalDate.of(2023, 8, 9));
//        client.setAmountSpent(12.2);
//        client.setStatus(ClientStatus.ACTIVE);
//        clientService.addClient(client);


        String localDate = "2023-04-21";
        String localDate1 = "2023-07-29";
        String localDate2 = "2019-08-26";
//
//        Visitor visitor = new Visitor();
//        visitor.setName("Олег");
//        visitor.setSurname("Олегов");
//        visitor.setTelephone("+37544762752");
//        visitor.setAge(35);
//        visitor.setFirstVisit(LocalDate.parse(localDate, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//        visitor.setLastVisit(LocalDate.parse(localDate1, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//        visitor.setAmountSpent(14.7);
//        visitor.setStatus(ClientStatus.ACTIVE);
//        visitor.setAddress(new Address("Минск", "Иванова", "31", "243761"));
//        clientService.addClient(visitor);

//        Employee employee = new Employee();
//        employee.setName("Игорь");
//        employee.setSurname("Некрутой2");
//        employee.setAge(29);
//        employee.setDateEnter(LocalDate.parse(localDate2, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//        employee.setDateExit(LocalDate.parse(localDate1, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//        employee.setPost("Администратор");
//        employee.setSalary(new BigDecimal(1400));
//        employee.setAddress(new Address("Минск", "Тимошенко", "10", "243456"));
//        clientService.addClient(employee);
//
//        Client client = clientService.findById(1L);
//        RecordsWithFields recordsWithFields = new RecordsWithFields(null, client, null, null);
//        recordsRepositoryHibernate.addRecords(recordsWithFields);
//       clientService.delete(1L);

//        System.out.println(clientService.findByName("Игорь"));
        LocalDate startDate = LocalDate.parse(localDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate endDate = LocalDate.parse(localDate1, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

//        Attendance attendance1 = new Attendance(null, startDate, new BigDecimal(12), 1L, null);
//        Attendance attendance2 = new Attendance(null, endDate, new BigDecimal(19), 3L, null);
//        attendanceService.addAttendance(attendance1);
//        attendanceService.addAttendance(attendance2);

        EmployeeRepositoryHibernate employeeRepositoryHibernate = new EmployeeRepositoryHibernate();
//        ActivitiesRepositoryHibernate activitiesRepositoryHibernate = new ActivitiesRepositoryHibernate();
//        activitiesRepositoryHibernate.addActivities(new Activities(null, "Лифтинг", 6.5));
//        System.out.println(employeeRepositoryHibernate.findByMinSalary());
//        AttendanceRepositoryHibernate attendanceRepositoryHibernate = new AttendanceRepositoryHibernate();
//        System.out.println(attendanceRepositoryHibernate.findSumByDate(startDate, endDate));
//        System.out.println(officeRepositoryHibernate.getAllCountOfPeopleInComplex());
//        System.out.println(clientRepositoryHibernate.findAgeByRange(25, 44));
//        System.out.println(officeRepositoryHibernate.findMaxCountAndPrice(15, new BigDecimal(10)));
//        attendanceRepositoryHibernate.updateVisitorId(1L, 9L);
//        attendanceRepositoryHibernate.updateVisitorId(2L, 9L);
//        attendanceRepositoryHibernate.updateVisitorId(3L, 10L);
//        attendanceRepositoryHibernate.updateVisitorId(4L, 10L);
//        attendanceRepositoryHibernate.updateVisitorId(5L, 11L);
//        attendanceRepositoryHibernate.updateVisitorId(6L, 12L);
//        System.out.println(attendanceRepositoryHibernate.findNameAndAgeVisitors("Олег", 35));
        officeRepositoryHibernate.getAllOfficesAndAllActivitiesAndOfficeById(16L);

    }
}
