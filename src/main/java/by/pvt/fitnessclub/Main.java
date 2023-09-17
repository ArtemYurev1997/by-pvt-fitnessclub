package by.pvt.fitnessclub;

import by.pvt.fitnessclub.entity.Attendance;
import by.pvt.fitnessclub.entity.Client;
import by.pvt.fitnessclub.enums.ClientStatus;
import by.pvt.fitnessclub.repository.jpa.AttendanceRepositoryHibernate;
import by.pvt.fitnessclub.repository.jpa.ClientRepositoryHibernate;
import by.pvt.fitnessclub.repository.jpa.OfficeRepositoryHibernate;
import by.pvt.fitnessclub.service.AttendanceService;
import by.pvt.fitnessclub.service.ClientService;
import by.pvt.fitnessclub.service.OfficeService;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ClientService clientService = new ClientService(new ClientRepositoryHibernate());
        OfficeService officeService = new OfficeService(new OfficeRepositoryHibernate());
        AttendanceService attendanceService = new AttendanceService(new AttendanceRepositoryHibernate());

//        OfficeRepositoryHibernate officeRepositoryHibernate = new OfficeRepositoryHibernate();
//        officeRepositoryHibernate.addOffice(new Office("Тренажерный зал", 141455L, 15, OfficeStatus.ACTIVE, new BigDecimal(10.0)));
//        officeRepositoryHibernate.addOffice(new Office("Теннисный корт", 1654276L, 4, OfficeStatus.ACTIVE, new BigDecimal(23.0)));
//        officeRepositoryHibernate.addOffice(new Office("Футбольный зал", 3672341L, 10, OfficeStatus.ACTIVE, new BigDecimal(16.0)));
//        officeRepositoryHibernate.addOfficeWithInventoryNumber(9L, 123456L);

//        System.out.println(officeRepositoryHibernate.updateCountOfPeople(9L, 20));
//        officeRepositoryHibernate.delete(1L);
//        System.out.println(officeRepositoryHibernate.updatePriceForHour(9L, new BigDecimal(15.0)));
//        System.out.println(officeRepositoryHibernate.priceForOffices(9L));
//        System.out.println(officeService.getSmallOffices());
        System.out.println(clientService.getAllClients());
        System.out.println(officeService.getSmallOfficesPrices());
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

//        System.out.println(clientService.getAllClients());
//        System.out.println(clientService.findById(2L));
    }
}
