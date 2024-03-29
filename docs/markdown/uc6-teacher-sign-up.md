# ΠΧ6. Εγγραφή Καθηγητή

**Πρωτεύων Actor**: Καθηγητής
**Ενδιαφερόμενοι**: <br>
* <b>Καθηγητής:</b> Θέλει να μπορεί να κάνει εγγραφή στην εφαρμογή για να μπορεί να προσφέρει υλικό στους μαθητές.

**Προϋποθέσεις**: Ο καθηγητής έχει εγκασταστήσει την εφαρμογή στο κινητό του, είναι τουλάχιστον 18 χρονών, έχει προσωπικό λογαριασμό email και έχει πτυχίο πανεπιστημίου.

## Βασική Ροή

### Α) Eγγραφή Καθηγητή

1. Ο καθηγητής εισάγει σε μία φόρμα το email του, έναν κωδικό πρόσβασης, το ονοματεπώνυμο του, την ειδικότητά του , το ΑΦΜ του και έναν αριθμό IBAN του και πατάει το κουμπί "Εγγραφή" για να καταχωρηθούν τα στοιχεία του στο σύστημα.
2. Το σύστημα ενημερώνει τον καθηγητή πως τα στοιχεία του είναι έγκυρα και δίνει στον καθηγητή έναν μοναδικό κωδικό μητρώου.
3. Ο καθηγητής επιλέγει το κουμπί "Αρχική σελίδα".
4. Το σύστημα ανακατευθύνει τον καθηγητή στην αρχική σελίδα της εφαρμογής.

## Εναλλακτικές ροές
2.α. Τα στοιχεία εγγραφής δεν είναι έγκυρα, καθώς παραβιάζεται κάποιος από τους κανόνες
[ΕΚ1, ΕΚ2, ΕΚ3, ΕΚ4](software-requirements.md).
1. O καθηγητής ενημερώνεται για τους λόγους που τα στοιχεία του δεν είναι έγκυρα (πχ. ότι το @ λείπει από τη διεύθυνση email)
2. Η περίπτωση χρήσης επιστρέφει στο βήμα 1 της βασικής ροής.

2.β. Ο χρήστης δεν έχει συμπληρώσει όλα τα υποχρεωτικά πεδία της φόρμας, καθώς παραβιάζεται κάποιος από τους κανόνες
[ΕΚ8, ΕΚ10](software-requirements.md).
1. Το σύστημα ενημερώνει το μαθητή ότι δεν έχει συμπληρώσει όλα τα απαραίτητα στοιχεία για την εγγραφή του.
2. Η περίπτωση χρήσης επιστρέφει στο βήμα 1 της βασικής ροής.
