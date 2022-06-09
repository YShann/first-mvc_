package tw.edu.ntub.imd.birc.firstmvc.dto.file.uploader;

import tw.edu.ntub.imd.birc.firstmvc.dto.file.directory.Directory;
import tw.edu.ntub.imd.birc.firstmvc.exception.file.FileException;

import javax.annotation.Nonnull;

@FunctionalInterface
public interface Uploader {
    @Nonnull
    UploadResult upload(@Nonnull Directory uploadTo) throws FileException;
}
