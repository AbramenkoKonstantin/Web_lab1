data class Contact(val name: String, val phoneNumber: String)

class MobilePhone {

    private val myContacts = ArrayList<Contact>()

    fun addNewContact(contact: Contact): Boolean {
        if (findContact(contact) >= 0) {
            println("Контакт уже существует")
            return false
        }
        myContacts.add(contact)
        return true
    }

    fun updateContact(oldContact: Contact, newContact: Contact): Boolean {
        val position = findContact(oldContact)
        if (position < 0) {
            println("Контакт не найден")
            return false
        }
        val name = myContacts[position].name
        myContacts[position] = newContact
        println("Контакт $name успешно обновлен")
        return true
    }

    fun removeContact(contact: Contact): Boolean {
        val position = findContact(contact)
        if (position < 0) {
            println("Контакт не найден")
            return false
        }
        val name = myContacts[position].name
        myContacts.removeAt(position)
        println("Контакт $name успешно удален")
        return true
    }

    private fun findContact(contact: Contact): Int {
        return myContacts.indexOf(contact)
    }

    fun queryContact(name: String): Contact? {
        for (i in myContacts.indices) {
            val contact = myContacts[i]
            if (contact.name == name) {
                println("Контакт $name найден:")
                println("${myContacts[i].name} -> ${myContacts[i].phoneNumber}")
                return contact
            }
        }
        println("Контакт $name не найден")
        return null
    }

    fun printContacts() {
        println("Список контактов:")
        for (i in myContacts.indices) {
            println("${i + 1}. ${myContacts[i].name} -> ${myContacts[i].phoneNumber}")
        }
    }
}

fun main() {
    val mobilePhone = MobilePhone()
    mobilePhone.addNewContact(Contact("John", "555-1234"))
    mobilePhone.addNewContact(Contact("Mike", "555-5678"))
    mobilePhone.printContacts()
    println()
    mobilePhone.updateContact(Contact("John", "555-1234"), Contact("Johnny", "555-9999"))
    println()
    mobilePhone.printContacts()
    println()
    mobilePhone.removeContact(Contact("Mike", "555-5678"))
    println()
    mobilePhone.printContacts()
    println()
    mobilePhone.queryContact("Johnny")
}