# zadanie 2: Stwórz kalkulator do obliczenia aktualnej godziny w konkretnej strefie czasowej. Do zadania wystarczy utworzyć słownik z przesunięciami czasowymi z i od UTC.

from datetime import datetime, timedelta

Utc = {
        'UTC-12:00': '-12',
        'UTC-11:00': '-11',
        'UTC-10:00': '-10',
        'UTC-09:30': '-9.5',
        'UTC-08:00': '-8',
        'UTC-07:00': '-7',
        'UTC-06:00': '-6',
        'UTC-05:00': '-5',
        'UTC-04:00': '-4',
        'UTC-03:30': '-3.5',
        'UTC-03:00': '-3',
        'UTC-02:00': '-2',
        'UTC-01:00': '-1',
    
        'UTC-00:00': '0',
        'UTC+00:00': '0',
    
        'UTC+01:00': '1',
        'UTC+02:00': '2',
        'UTC+03:00': '3',
        'UTC+03:30': '3.5',
        'UTC+04:00': '4',
        'UTC+04:30': '4.5',
        'UTC+05:00': '5',
        'UTC+05:30': '5.5',
        'UTC+05:45': '5.75',
        'UTC+06:00': '6',
        'UTC+06:30': '6.5',
        'UTC+07:00': '7',
        'UTC+08:00': '8',
        'UTC+09:00': '9',
        'UTC+09:30': '9.5',
        'UTC+10:00': '10',
        'UTC+10:30': '10.5',
        'UTC+11:00': '11',
        'UTC+11:30': '11.5',
        'UTC+12:00': '12',
        'UTC+12:45': '12.75',
        'UTC+13:00': '13',
        'UTC+14:30': '14.5'
      }

stop = False;
counter = 0;

while not stop:
    timeZone = input("Enter a time zone (please write the correct format eg UTC+10:00 or UTC-10:00): ")
    try:
        amountOfHours = Utc[timeZone]
        stop = True;
    except Exception as e:
        if counter >= 3:
            print("Please write the correct format! Choose one of the following: UTC-12:00, UTC-11:00, UTC-10:00, UTC-09:30, UTC-08:00, UTC-07:00, UTC-06:00, UTC-05:00, UTC-04:00, UTC-03:30, UTC-03:00, UTC-02:00, UTC-01:00, UTC-00:00, UTC+00:00, UTC+01:00, UTC+02:00, UTC+03:00, UTC+03:30, UTC+04:00, UTC+04:30, UTC+05:00, UTC+05:30, UTC+05:45, UTC+06:00, UTC+06:30, UTC+07:00, UTC+08:00, UTC+09:00, UTC+09:30, UTC+10:00, UTC+10:30, UTC+11:00, UTC+11:30, UTC+12:00, UTC+12:45, UTC+13:00, UTC+14:30\n")
        else:
            print("Please write the correct format eg UTC+10:00 or UTC-10:00\n")
        counter += 1
        stop = False
    
now = datetime.now()
newTime = now + timedelta(hours=(float(amountOfHours)))

print("\nCurrent time in your zone: ")
print(now.strftime('%H:%M:%S'))

print("\nTime in choosen zone: ")
print(newTime.strftime('%H:%M:%S'))