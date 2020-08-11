package com.sohailshrestha.services.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*
*Created by Sohail Shrestha on 6/10/2020 11
*/
@Entity(tableName = "user_data")
data class UserData(
    @PrimaryKey
    val id: Int?,
    val firstName: String?,
    val lastName: String?,
    val phone: String?,
    val email: String?,
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    val profileImage: ByteArray?

    ) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as UserData

        if (id != other.id) return false
        if (firstName != other.firstName) return false
        if (lastName != other.lastName) return false
        if (phone != other.phone) return false
        if (email != other.email) return false
        if (profileImage != null) {
            if (other.profileImage == null) return false
            if (!profileImage.contentEquals(other.profileImage)) return false
        } else if (other.profileImage != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id ?: 0
        result = 31 * result + (firstName?.hashCode() ?: 0)
        result = 31 * result + (lastName?.hashCode() ?: 0)
        result = 31 * result + (phone?.hashCode() ?: 0)
        result = 31 * result + (email?.hashCode() ?: 0)
        result = 31 * result + (profileImage?.contentHashCode() ?: 0)
        return result
    }
}