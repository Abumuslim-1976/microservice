package uz.uzcard.services.group.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import uz.uzcard.service.dbservice.dto.ApiResponse;
import uz.uzcard.service.dbservice.dto.GroupDto;
import uz.uzcard.service.dbservice.entity.Group;
import uz.uzcard.service.dbservice.repository.GroupRepository;
import uz.uzcard.service.dbservice.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/group")
public class GroupController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GroupController.class);
    private final GroupRepository groupRepository;

    @GetMapping("/get/{id}")
    public Group getGroup(@PathVariable Long id) {
        Optional<Group> groupById = groupRepository.findById(id);
        return groupById.orElse(null);
    }

    @GetMapping("/getAllGroup")
    public List<Group> getAllGroup() {
        return groupRepository.findAll();
    }

    @PostMapping("/add")
    public ApiResponse<Group> addGroup(@RequestBody GroupDto groupDto) {
        try {
            Group group = new Group();
            group.setName(groupDto.getName());
            group.setGroupNumber(groupDto.getGroupNumber());
            groupRepository.save(group);
            return new ApiResponse<>("success", group, true);
        } catch (Exception e) {
            return new ApiResponse<>("error", false);
        }
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Group> deleteGroup(@PathVariable Long id) {
        try {
            groupRepository.deleteById(id);
            return new ApiResponse<>("success", true);
        } catch (Exception e) {
            return new ApiResponse<>("error", false);
        }
    }

}
